package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/allusers")
    public List<User> getAllUsers(){return userService.getAll();}

    @GetMapping("/registerUser")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        return "userRegister";
    }

    @PostMapping("/registerUser")
    public String registerUserAccount(Model model,User user){
        userRepository.save(user);
        model.addAttribute("user",user);
        return "userSaved";
    }

}