package com.evo.be_jwt_user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {

    private String userName;
    private String userPassword;
}
