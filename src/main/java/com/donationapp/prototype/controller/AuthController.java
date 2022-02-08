package com.donationapp.prototype.controller;

import com.donationapp.prototype.repository.DonateArticleRepository;
import com.donationapp.prototype.repository.InvoiceRepository;
import com.donationapp.prototype.repository.UserRepository;
import com.donationapp.prototype.service.DonateArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;


@Controller
@RequestMapping(path="/admin")
public class AuthController {
    @Autowired
    DonateArticleService donateArticleService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    DonateArticleRepository donateArticleRepository;

    @GetMapping("/invoices")
    public String invoices(Model model)
    {
        model.addAttribute("invoices",invoiceRepository.findAll());
        return "adminInvoices";
    }

    @Transactional
    @RequestMapping(value = "/articles/{name}", method = RequestMethod.GET)
    public String remove(@PathVariable String name,Model model)
    {
        donateArticleRepository.deleteDonateArticleByArticleName(name);
        model.addAttribute("articles",donateArticleRepository.findAll());
        return "adminArticles";
    }

    @Transactional
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    public String removeInvoice(@PathVariable int id,Model model)
    {
        invoiceRepository.deleteInvoiceByInvoiceId(id);
        model.addAttribute("invoices",invoiceRepository.findAll());
        return "adminInvoices";
    }

    @Transactional
    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public String removeUsers(@PathVariable String name,Model model)
    {
        userRepository.deleteUserByUsername(name);
        model.addAttribute("users",userRepository.findAll());
        return "adminUsers";
    }

    @GetMapping("/articles")
    public String articles(Model model)
    {
        model.addAttribute("articles",donateArticleRepository.findAll());
        return "adminArticles";
    }

    @GetMapping("/users")
    public String users(Model model)
    {
        model.addAttribute("users",userRepository.findAll());
        return "adminUsers";
    }
    @GetMapping("/")
    public String invoices()
    {
        return "adminPanel";
    }



}
