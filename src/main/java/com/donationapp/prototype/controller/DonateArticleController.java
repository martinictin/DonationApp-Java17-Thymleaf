package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.DonateArticle;
import com.donationapp.prototype.service.DonateArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DonateArticleController {
    @Autowired
    DonateArticleService donateArticleService;

    @GetMapping("/all")
    public List<DonateArticle> getAllArticles(){return donateArticleService.getAllArticles();}

   
}
