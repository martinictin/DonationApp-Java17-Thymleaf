package com.donationapp.prototype.service;

import com.donationapp.prototype.model.DonateArticle;
import com.donationapp.prototype.model.paging.Paged;
import com.donationapp.prototype.model.paging.Paging;
import com.donationapp.prototype.repository.DonateArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonateArticleService implements IDonateArticleService {

    @Autowired
    DonateArticleRepository donateArticleRepository;

    public List<DonateArticle> getAllArticles(){
    List<DonateArticle> donateArticles=new ArrayList<>();
        donateArticles.addAll(donateArticleRepository.findAll());

    return donateArticles;
    }

    public DonateArticle getArticle(int id){
        Optional<DonateArticle> tempArticle=donateArticleRepository.findById(id);

        if(tempArticle.isEmpty()){
            DonateArticle article=new DonateArticle();
            article.setArticleId(id);
            return article;
        }
        return tempArticle.get();

    }

    public void fromDbToRepo() throws SQLException, ClassNotFoundException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/donationdb";
        Class.forName(myDriver);
        String query = "SELECT * FROM donate_article";
        Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            DonateArticle donateArticle = new DonateArticle();
            donateArticle.setArticleId(rs.getInt("article_id"));
            donateArticle.setArticleName(rs.getString("article_name"));
            donateArticle.setDescription(rs.getString("description"));
            donateArticle.setPublicKey(rs.getString("public_key"));
            donateArticle.setSecretKey(rs.getString("secret_key"));
            donateArticle.setCreatedBy(rs.getString("created_by"));
            donateArticleRepository.save(donateArticle);
        }
        st.close();
    }


    public void update(DonateArticle donateArticle){
        donateArticleRepository.saveAndFlush(donateArticle);
    }

    public void delete(int id){
        donateArticleRepository.deleteById(id);
    }

    public Paged<DonateArticle> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size);
        Page<DonateArticle> postPage = donateArticleRepository.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }

    public DonateArticle getArticleById(int id) {
        Optional < DonateArticle > optional = donateArticleRepository.findById(id);
        DonateArticle donateArticle = null;
        if (optional.isPresent()) {
            donateArticle = optional.get();
        } else {
            throw new RuntimeException(" Article not found for id :: " + id);
        }
        return donateArticle;
    }

    public void deleteArticleById(int id) {
        this.donateArticleRepository.deleteById(id);
    }
}
