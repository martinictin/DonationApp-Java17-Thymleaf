package com.donationapp.prototype.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChargeRequest {

    public enum Currency {
        EUR, USD;
    }
    private String description;
    private int amount; // cents
    private Currency currency;
    private String stripeToken ;
    private String secretKey;
    private String donatorName;
    private String donation;

    
    
}
