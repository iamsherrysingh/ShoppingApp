package com.sherry.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.sherry.frontend.model.AuthenticateRequest;
import com.sherry.frontend.model.AuthenticationResponse;
import com.sherry.frontend.service.MyUserDetailService;
import com.sherry.frontend.util.JwtUtil;

@RestController
@RequestMapping
public class FrontendController {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = {"/", ""})
    public String sayHello() {
        return "<h1>Welcome to Spring Shopping Mall</>";
    }

    @GetMapping(value = {"/user"})
    public String helloUser() {
        return "Welcome User";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticateRequest.getUsername(),
                            authenticateRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }
        //Authentication Successful

        UserDetails userDetails = myUserDetailService
                .loadUserByUsername(authenticateRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
