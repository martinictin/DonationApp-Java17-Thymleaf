package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.DonateArticleRepository;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.DonateArticleService;
import com.donationapp.prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    DonateArticleService donateArticleService;

    @Autowired
    DonateArticleRepository donateArticleRepository;

    @GetMapping("/index")
    public String viewMainPage(Model model) throws ClassNotFoundException, SQLException {
        userService.fromDbToRepo();
        donateArticleService.fromDbToRepo();
        model.addAttribute("user",userRepository.findAll());
        model.addAttribute("donateArticle",donateArticleRepository.findAll());
        return "index";
    }





}