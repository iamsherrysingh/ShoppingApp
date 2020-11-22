package com.sherry.frontend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @Column(name = "user_name")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "active")
    Boolean active;

    @Column(name = "role")
    String role;

    @Transient
    ArrayList<SimpleGrantedAuthority> authorities;

    public User() {
    }

    public User(String username, String password, Boolean active, String role) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    @Override
	public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public String getRole() {
        return role;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //If authorities list has already been built, return it
        if (authorities != null)
            return authorities;

        //building authorities list using this.role from DB
        authorities = new ArrayList<>();
        Arrays.asList(role.split(",")).forEach(r -> authorities.add(new SimpleGrantedAuthority(r)));
        return authorities;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", authority='" + getAuthorities().toString() + '\'' +
                '}';
    }
}
