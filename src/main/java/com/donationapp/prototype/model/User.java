package com.donationapp.prototype.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users",
        uniqueConstraints={
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String userPassword;

    /**
     * Set relations manytomany over user_roles between tables User and Role
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))

    private Collection<Role> roles;

    public User(String username,String email,String userPassword){
        this.username=username;
        this.email=email;
        this.userPassword=userPassword;
    }
    public User(){

    }

    public <T> User(String username, String email, String password, Role role_user) {
        this.username=username;
        this.email=email;
        this.userPassword=userPassword;
        this.roles.add(role_user);
    }
}
