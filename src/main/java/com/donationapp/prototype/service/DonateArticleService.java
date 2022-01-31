package com.donationapp.prototype.service;

import com.donationapp.prototype.model.DonateArticle;
import com.donationapp.prototype.repository.DonateArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public void update(DonateArticle donateArticle){
        donateArticleRepository.saveAndFlush(donateArticle);
    }

    public void delete(int id){
        donateArticleRepository.deleteById(id);
    }
}
