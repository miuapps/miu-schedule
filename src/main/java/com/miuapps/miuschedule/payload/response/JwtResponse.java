package com.miuapps.miuschedule.payload.response;

import lombok.Data;

import java.util.List;

/**
 * The type Jwt response.
 */
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    /**
     * Instantiates a new Jwt response.
     *
     * @param accessToken the access token
     * @param id          the id
     * @param username    the username
     * @param email       the email
     * @param roles       the roles
     */
    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

}