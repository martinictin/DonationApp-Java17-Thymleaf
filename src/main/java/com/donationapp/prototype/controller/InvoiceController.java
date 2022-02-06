package com.donationapp.prototype.controller;

import com.donationapp.prototype.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/admin")
@Controller
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoice")
    public String list(Model model){
        model.addAttribute("invoice", invoiceService.setInvoice());
        return "invoices";
    }

}
