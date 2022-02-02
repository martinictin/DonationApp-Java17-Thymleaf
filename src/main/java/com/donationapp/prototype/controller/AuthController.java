package com.donationapp.prototype.controller;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user")SignUpRequest signUpRequest){
        userService.save(signUpRequest);
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
