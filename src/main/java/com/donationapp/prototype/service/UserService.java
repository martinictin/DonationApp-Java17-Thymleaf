package com.donationapp.prototype.service;

import com.donationapp.prototype.dto.SignUpRequest;
import com.donationapp.prototype.model.Role;
import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
