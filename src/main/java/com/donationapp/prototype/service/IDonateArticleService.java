package com.donationapp.prototype.service;

import com.donationapp.prototype.model.DonateArticle;

import java.sql.SQLException;
import java.util.List;

public interface IDonateArticleService {
    List<DonateArticle> getAllArticles();
    DonateArticle getArticle(int id);
    void update(DonateArticle donateArticle);
    void delete(int id);
    void fromDbToRepo() throws SQLException, ClassNotFoundException;

}
