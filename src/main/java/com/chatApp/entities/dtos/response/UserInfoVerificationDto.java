package com.chatApp.entities.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVerificationDto {
    private int id;
    private String username;
    private String email;
    private boolean isVerify;

}
