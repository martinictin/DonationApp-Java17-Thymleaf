package com.donationapp.prototype.service;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.model.Role;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    public User saveUser(SignUpRequest signUpRequest){
       User user=new User(signUpRequest.getUsername(),
               signUpRequest.getEmail(),
               signUpRequest.getPassword(),
               (Role) Arrays.asList(new Role("ROLE_USER")));

       return  userRepository.save(user);
   }

    public List<User> getAll(){
        List<User> userList=new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUser(int id){
        Optional<User> tempUser=userRepository.findById(id);

        if(tempUser.isEmpty()){
            User user=new User();
            user.setUserId(id);
            return user;
        }
        return tempUser.get();
    }

    public void fromDbToRepo() throws SQLException, ClassNotFoundException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/donationdb";
        Class.forName(myDriver);
        String query = "SELECT * FROM users";
        Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setUserPassword(rs.getString("user-password"));
            userRepository.save(user);
        }
        st.close();
    }


    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
