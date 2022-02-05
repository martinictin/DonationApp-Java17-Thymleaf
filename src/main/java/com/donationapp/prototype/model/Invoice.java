package com.donationapp.prototype.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceId;

    @Column
    private String status;
    @Column
    private Date date;
    @Column
    private String donator;
    @Column
    private String receiver;


}
