package com.exambuilder.controller;

import com.exambuilder.model.User;
import com.exambuilder.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserManagement {

    @Autowired
    UserDetailsServiceImpl userDetails;

    @PostMapping
    @RequestMapping("v1/public/login")
    public String login(@RequestBody User user){
        return userDetails.loginByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @PostMapping
    @RequestMapping("v1/private/createuser")
    public User createUser(@RequestBody User user){
        return userDetails.saveUser(user);
    }

}
