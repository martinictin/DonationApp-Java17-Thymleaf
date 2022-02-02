package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(Model model,User user){
        userRepository.save(user);
        model.addAttribute("user",user);
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
