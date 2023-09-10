package com.chatApp.entities.dtos.request;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
