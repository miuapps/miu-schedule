package com.miuapps.miuschedule.payload.request;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * The type Login request.
 */
@Data
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}