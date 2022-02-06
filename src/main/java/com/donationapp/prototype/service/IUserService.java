package com.donationapp.prototype.service;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface IUserService extends UserDetailsService {
    //User saveUser(SignUpRequest signUpRequest);

    List<User> getAll();

    User getUser(int id);

    void deleteUser(int id);

    void fromDbToRepo() throws SQLException, ClassNotFoundException;

    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;

    String register(SignUpRequest request);

    String signUpUser(User user);

    String buildEmail(String name, String link);

    String confirmToken(String token);

    int enableUser(String email);

}
