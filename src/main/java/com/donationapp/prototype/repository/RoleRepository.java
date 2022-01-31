package com.donationapp.prototype.repository;

import com.donationapp.prototype.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    //Optional<Role> findbyName(ERole name);
}
