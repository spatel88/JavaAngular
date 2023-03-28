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

    public List<User> getFriends(){
        return repository.findAll();
    }

    public void  addFriend(User user){
        repository.save(user);
    }

    public void updateFriend(User user){
        repository.save(user);
    }

    public void deleteFriend(Integer id){
        repository.deleteById(id);
    }
}
