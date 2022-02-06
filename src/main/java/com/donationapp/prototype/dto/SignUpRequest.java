package com.donationapp.prototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SignUpRequest {

    private final String username;
    private final String email;
    private final String password;
    @Enumerated
    private final String role;
}
