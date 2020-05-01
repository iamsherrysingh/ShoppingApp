package com.sherry.FrontendMicroService.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationResponse {

    private String jwt="";

    /*public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }*/

    public String getJwt() {
        return jwt;
    }
}

