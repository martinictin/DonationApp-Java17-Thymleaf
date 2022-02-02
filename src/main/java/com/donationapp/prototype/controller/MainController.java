package com.donationapp.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Login form
    @GetMapping("/index")
    public String viewMainPage() {
        // custom logic before showing login page...

        return "index";
    }





}