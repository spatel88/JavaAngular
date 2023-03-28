package com.learning.userapi.controller;

import com.learning.userapi.service.UserService;
import com.learning.userapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getFriends(){
       return service.getFriends();
    }

    @PostMapping("/users/addnew")
    public void addFriend(@RequestBody User user){
        service.addFriend(user);
    }

    @PutMapping("/users/{id}/edit")
    public void updateFriend(@PathVariable("id") Integer id, @RequestBody User user){
        service.updateFriend(user);
    }

    @DeleteMapping("/users/{id}/delete")
    public void deleteFriend(@PathVariable("id") Integer id){
        service.deleteFriend(id);
    }

}
