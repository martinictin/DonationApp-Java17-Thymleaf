package com.donationapp.prototype.service;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.model.User;

import java.sql.*;
import java.util.List;

public interface IUserService {
    User saveUser(SignUpRequest signUpRequest);

    List<User> getAll();

    User getUser(int id);

    void deleteUser(int id);

    void fromDbToRepo() throws SQLException, ClassNotFoundException;
}
