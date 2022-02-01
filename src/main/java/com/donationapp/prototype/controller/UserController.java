package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public List<User> getAllUsers(){return userService.getAll();}


}