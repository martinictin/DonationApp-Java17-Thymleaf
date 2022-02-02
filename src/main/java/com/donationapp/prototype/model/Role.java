package com.donationapp.prototype.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole roleName;

    public Role (String roleName){
        this.roleName= ERole.valueOf(roleName);
    }

    public Role() {

    }
}
