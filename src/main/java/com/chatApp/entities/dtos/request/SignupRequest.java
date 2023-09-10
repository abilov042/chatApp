package com.chatApp.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
