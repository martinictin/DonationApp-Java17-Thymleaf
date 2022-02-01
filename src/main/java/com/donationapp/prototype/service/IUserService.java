package com.donationapp.prototype.service;

import com.donationapp.prototype.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User getUser(int id);
    void deleteUser(int id);
}
