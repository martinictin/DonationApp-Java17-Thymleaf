package com.donationapp.prototype.repository;

import com.donationapp.prototype.model.DonateArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateArticleRepository extends JpaRepository<DonateArticle,Integer> {

}
