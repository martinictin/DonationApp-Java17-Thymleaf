package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public List<User> getAllUsers(){return userService.getAll();}

    @GetMapping("/userRegister")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user")
    public String submit(User user, Model model) {
        model.addAttribute("user", user);
        return "saved";
    }


}