package com.donationapp.prototype.controller;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private UserRepository userRepository;

    @PostMapping
    public String register(@RequestBody SignUpRequest request) {
        return userService.register(request);
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

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
        return "index";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return userService.confirmToken(token);
    }



}
