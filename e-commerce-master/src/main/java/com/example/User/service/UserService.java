package com.example.User.service;

import com.example.User.models.User;
import com.example.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository repository;
    public List<User> getAllUser(){
        return repository.findAll();
    }
    public String insertUser(User user){
    List<User> allUsers = repository.findAll();
        for(User user1: allUsers) {
            if (user1.getEmail().equals(user.getEmail())) {
                return "User email already registered.";
            }
        }

        repository.save(user);
        return "user Saved";

    }
    public String deleteUser(long id){
        repository.deleteById(id);
        return "deleted";
    }
}
