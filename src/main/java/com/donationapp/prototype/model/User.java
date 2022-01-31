package com.donationapp.prototype.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
/*
@Table(name="users",
        uniqueConstraints={
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })

 */
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userUsername;


    private String userEmail;

    private String userPassword;

    /**
     * Set relations manytomany over user_roles between tables User and Role
     */
    @ManyToMany(fetch=FetchType.LAZY)
    /*
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))

     */
    private Set<Role> roles=new HashSet<>();

}
