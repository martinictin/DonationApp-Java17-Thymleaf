package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.ChargeRequest;
import com.donationapp.prototype.repository.DonateArticleRepository;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.DonateArticleService;
import com.donationapp.prototype.service.StripeService;
import com.donationapp.prototype.service.UserService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Controller
@RequestMapping(path="/user")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    DonateArticleService donateArticleService;

    @Autowired
    DonateArticleRepository donateArticleRepository;

    @Autowired
    StripeService paymentsService;

    /*
    @GetMapping("/")
    public String viewMainPage(Model model) throws ClassNotFoundException, SQLException {
        userService.fromDbToRepo();
        donateArticleService.fromDbToRepo();
        model.addAttribute("user",userRepository.findAll());
        model.addAttribute("donateArticle",donateArticleRepository.findAll());
        return "index";
    }

     */
    @GetMapping("/")
    public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "5") int size, Model model) throws SQLException, ClassNotFoundException {
        userService.fromDbToRepo();
        donateArticleService.fromDbToRepo();
        model.addAttribute("posts", donateArticleService.getPage(pageNumber, size));
        model.addAttribute("amount", new ChargeRequest());
        return "index";
    }

    @GetMapping("/result")
    public String input(Model model) {
        model.addAttribute("amount",new ChargeRequest() ); // in cents
        return "index";
    }

    @PostMapping("/result")
    public String output(ChargeRequest chargeRequest, Model model) throws StripeException {
        chargeRequest.setDescription("Donation");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        model.addAttribute("date",formatter.format(calendar.getTime()));
        model.addAttribute("amount",charge.getAmount());
        model.addAttribute("currency",chargeRequest.getCurrency());
        return "result";
    }







}