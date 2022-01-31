package com.donationapp.prototype.repository;

import com.donationapp.prototype.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //Optional<User> findByUsername(String username);
    //Boolean checkByUsername(String username);
    //Boolean checkByEmail(String email);
}
