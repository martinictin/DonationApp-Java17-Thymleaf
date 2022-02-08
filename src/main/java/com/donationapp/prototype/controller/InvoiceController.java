package com.donationapp.prototype.controller;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.InvoiceRepository;
import com.donationapp.prototype.service.InvoiceService;
import com.stripe.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Controller
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("/invoice")
    public String list(Model model){
        model.addAttribute("invoice", invoiceService.setInvoice());
        return "invoices";
    }

    /*
    @GetMapping("/userInvoices")
    public String userInvoices(Model model)
    {
        model.addAttribute("invoices", new List<Invoice>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Invoice> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Invoice invoice) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Invoice> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Invoice> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Invoice get(int index) {
                return null;
            }

            @Override
            public Invoice set(int index, Invoice element) {
                return null;
            }

            @Override
            public void add(int index, Invoice element) {

            }

            @Override
            public Invoice remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Invoice> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Invoice> listIterator(int index) {
                return null;
            }

            @Override
            public List<Invoice> subList(int fromIndex, int toIndex) {
                return null;
            }
        });
        return "userInvoices";
    }


     */
    @GetMapping("/userInvoices")
    public String invoices(Model model,@AuthenticationPrincipal User user)
    {
        model.addAttribute("invoices",invoiceRepository.findAllByDonator(user.getUsername()));
        return "userInvoices";
    }
}
