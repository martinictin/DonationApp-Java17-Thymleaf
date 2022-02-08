package com.donationapp.prototype.repository;

import com.donationapp.prototype.model.DonateArticle;
import com.donationapp.prototype.model.paging.Paged;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface DonateArticleRepository extends JpaRepository<DonateArticle,Integer> {
    List<DonateArticle> findAllByArticleName(String name);
    List<DonateArticle> findAllByCreatedBy(String name);
}
