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
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.transaction.Transactional;
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

    @Transactional
    @RequestMapping(value = "/deleteDonation/{articleName}", method = RequestMethod.GET)
    public String delete(@PathVariable String articleName,Model model,@AuthenticationPrincipal User user)
    {
        donateArticleRepository.deleteDonateArticleByArticleName(articleName);
        model.addAttribute("donations",donateArticleRepository.findAllByCreatedBy(user.getUsername()));
        return "userDonations";
    }


    @Transactional
    @RequestMapping(value = "/updateDonation/{articleName}", method = RequestMethod.GET)
    public String update(@PathVariable String articleName,Model model)
    {
        model.addAttribute("donations",donateArticleRepository.findByArticleName(articleName));
        model.addAttribute("newDonation", new DonateArticle());
        return "editDonation";
    }

    @Transactional
    @RequestMapping(value = "/updateDonation/{articleName}", method = RequestMethod.POST)
    public String updateDonation(@PathVariable String articleName,Model model,@ModelAttribute("donations") DonateArticle donateArticle,@AuthenticationPrincipal User user){
        DonateArticle old = donateArticleRepository.findByArticleName(articleName);
        old.setCreatedBy(donateArticle.getCreatedBy());
        old.setArticleName(donateArticle.getArticleName());
        old.setDescription(donateArticle.getDescription());
        old.setPublicKey(donateArticle.getPublicKey());
        old.setSecretKey(donateArticle.getSecretKey());
        old.setUrl(donateArticle.getUrl());
        old.setArticlePriceTarget(donateArticle.getArticlePriceTarget());
        donateArticleRepository.save(old);

        donateArticleRepository.deleteDonateArticleByArticleName(articleName);
        model.addAttribute("donations",donateArticleRepository.findAllByCreatedBy(user.getUsername()));
        return "userDonations";
    }



}
