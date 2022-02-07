package com.donationapp.prototype.service;

import com.donationapp.prototype.model.Invoice;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.InvoiceRepository;
import com.donationapp.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
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
        //invoice.setDate(new Date());
        invoiceRepository.save(invoice);
        }
        return invoiceRepository.findAll();
    }

    public void fromDbToRepo() throws SQLException, ClassNotFoundException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl ="jdbc:mysql://localhost:3306/donationdb";
        Class.forName(myDriver);
        String query = "SELECT * FROM invoice";
        Connection conn = DriverManager.getConnection(myUrl, "root", "12345");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(rs.getInt("invoice_id"));
            invoice.setAmount(rs.getString("amount"));
            invoice.setReceiver(rs.getString("receiver"));
            invoice.setStatus(rs.getString("status"));
            invoice.setTransactionId(rs.getString("transaction_id"));
            invoice.setDate(rs.getString("date"));
            invoice.setDonator(rs.getString("donator"));
            invoiceRepository.save(invoice);
        }
        st.close();
    }
}
