package com.donationapp.prototype.controller;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("signup",new SignUpRequest());
        return "userRegister";
    }

    @PostMapping("/registerUser")
    public String registerUserAccount(Model model,SignUpRequest request){
        userService.register(request);
        model.addAttribute("signup",request);
        return "userSaved";
    }

    @GetMapping("/registeradmin")
    public String showRegistrationAdminForm(Model model){
        model.addAttribute("signup",new SignUpRequest());
        return "adminRegister";
    }

    @PostMapping("/registeradmin")
    public String registerAdminAccount(Model model,SignUpRequest request){
        userService.setAdmin(request);
        model.addAttribute("signup",request);
        return "userSaved";
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        userService.confirmToken(token);
        return "userConfirmed";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }



}