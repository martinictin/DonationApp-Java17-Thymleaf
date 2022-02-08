package com.donationapp.prototype.repository;

import com.donationapp.prototype.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    List<Invoice> findAllByDonator(String name);
    void deleteInvoiceByInvoiceId(int id);
}
