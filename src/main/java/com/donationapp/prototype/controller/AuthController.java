package com.donationapp.prototype.controller;

import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
    private UserService userService;
    @Autowired
    UserRepository userRepository;





}
