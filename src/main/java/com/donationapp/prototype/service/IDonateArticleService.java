package com.donationapp.prototype.service;

import com.donationapp.prototype.model.DonateArticle;

import java.util.List;

public interface IDonateArticleService {
    List<DonateArticle> getAllArticles();
    DonateArticle getArticle(int id);
    void update(DonateArticle donateArticle);
    void delete(int id);

}
