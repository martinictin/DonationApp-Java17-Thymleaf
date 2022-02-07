package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.ChargeRequest;
import com.donationapp.prototype.model.DonateArticle;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.DonateArticleRepository;
import com.donationapp.prototype.service.DonateArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class DonateArticleController {
    @Autowired
    DonateArticleService donateArticleService;

    @Autowired
    DonateArticleRepository donateArticleRepository;

    @GetMapping("/all")
    public List<DonateArticle> getAllArticles(){return donateArticleService.getAllArticles();}



    @GetMapping("/registerDonationArticle")
    public String showRegistrationForm(Model model){
        model.addAttribute("donateArticle",new DonateArticle());
        return "donationRegister";
    }

    @GetMapping("/search")
    public String searchByName(Model model, String keyword)
    {
        model.addAttribute("amount", new ChargeRequest());
        model.addAttribute("posts",donateArticleRepository.findAllByArticleName(keyword));
        return "searchResult";
    }

    @PostMapping("/registerDonationArticle")
    public String registerUserAccount(Model model,DonateArticle donateArticle){
        donateArticleRepository.save(donateArticle);
        model.addAttribute("donateArticle",donateArticle);
        return "donationSaved";
    }

    @GetMapping("/userDonations")
    public String donations(Model model,@AuthenticationPrincipal User user)
    {
        model.addAttribute("donations",donateArticleRepository.findAllByCreatedBy(user.getUsername()));
        return "userDonations";
    }



}
