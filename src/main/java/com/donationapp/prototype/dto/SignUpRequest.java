package com.donationapp.prototype.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {


    private String username;


    private String email;
    private Set<String> role;


    private String password;
}
