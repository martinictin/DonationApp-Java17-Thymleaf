package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.DonateArticleRepository;
import com.donationapp.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DonateArticleRepository donateArticleRepository;

    @GetMapping("/index")
    public String viewMainPage(Model model) {
        model.addAttribute("user",userRepository.findAll());
        model.addAttribute("donateArticle",donateArticleRepository.findAll());
        return "index";
    }





}