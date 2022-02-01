package com.donationapp.prototype.service;

import com.donationapp.prototype.model.User;
import com.donationapp.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

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
