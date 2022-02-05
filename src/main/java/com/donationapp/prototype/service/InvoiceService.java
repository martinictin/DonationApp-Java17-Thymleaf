package com.donationapp.prototype.service;

import com.donationapp.prototype.model.Invoice;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.InvoiceRepository;
import com.donationapp.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    InvoiceRepository invoiceRepository;

    public List<Invoice> setInvoice(){
       List<User> lista = new ArrayList<>();
       lista=userRepository.findAll();
        for (User user : lista) {
        Invoice invoice = new Invoice();
        invoice.setDonator(user.getUsername());
        invoice.setDate(new Date());
        invoiceRepository.save(invoice);
        }
        return invoiceRepository.findAll();
    }
}
