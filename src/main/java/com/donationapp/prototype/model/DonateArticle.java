package com.donationapp.prototype.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class DonateArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;

    @Basic(optional = false)
    @Column
    private String articleName;
    @Column
    private double articlePriceTarget;
    @Column
    private String url;
    @Column
    private String description;

}
