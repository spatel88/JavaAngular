package com.learning.userapi.service;

import com.learning.userapi.repository.UserRepository;
import com.learning.userapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers(){
        return repository.findAll();
    }

    public void  addUser(User user){
        repository.save(user);
    }

    public void updateUser(User user){
        repository.save(user);
    }

    public void deleteUser(Integer id){
        repository.deleteById(id);
    }

    public User fetchUserByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email,password);
    }
}
