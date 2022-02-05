package com.donationapp.prototype.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InvoiceDto {
    String username;
    String article;
    String status;
    String reciever;
    Date date;
    int priceTarget;
    int initdonation;
    int total;

}
