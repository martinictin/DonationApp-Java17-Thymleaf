package com.donationapp.prototype.repository;

import com.donationapp.prototype.model.DonateArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateArticleRepository extends JpaRepository<DonateArticle,Integer> {
    List<DonateArticle> findAllByArticleName(String name);
    List<DonateArticle> findAllByCreatedBy(String name);
    void deleteDonateArticleByArticleName(String name);
}
