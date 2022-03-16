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
    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public List<String> getRoles() {
        return roles;
    }
}