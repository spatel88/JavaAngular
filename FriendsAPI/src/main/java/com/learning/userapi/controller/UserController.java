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
    public List<User> getUsers(){
       return service.getUsers();
    }

    @PostMapping("/users/addnew")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/users/{id}/edit")
    public void updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        service.updateUser(user);
    }

    @DeleteMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable("id") Integer id){
        service.deleteUser(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String password = user.getPassword();
        User userForEmailAndPassword = null;

        if(email != null && password != null){
            userForEmailAndPassword = service.fetchUserByEmailAndPassword(email,password);
        }
        if(userForEmailAndPassword == null){
            throw new Exception("bad credential");
        }

        return userForEmailAndPassword;
    }

}
