package com.example.facebookapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facebookapi.entity.User;
import com.example.facebookapi.service.UserService;

@RestController
@RequestMapping("/api/userService")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User submitUser(@RequestBody User body) {
        return userService.submitUserToDb(body);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsersFromDb();
    }

    @GetMapping("/getUserDetails/{userId}")
    public Optional<User> getUserDetails(@PathVariable("userId") UUID userId) {
        return userService.getUserDetailsFromDb(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public List<User> deleteUser(@PathVariable("userId") UUID userId) {
        return userService.deleteUserToDb(userId);
    }
}
