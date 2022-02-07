package com.donationapp.prototype.dto;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class SignUpRequest {

    private  String username;
    private  String email;
    private  String password;


}
