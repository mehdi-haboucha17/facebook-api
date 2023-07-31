package com.example.facebookapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.facebookapi.entity.User;
import com.example.facebookapi.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User submitUserToDb(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsersFromDb() {
        return userRepo.findAll();
    }

    public Optional<User> getUserDetailsFromDb(UUID userId) {
        return userRepo.findById(userId);
    }

    public List<User> deleteUserToDb(@PathVariable("userId") UUID userId) {
        userRepo.deleteById(userId);
        return getAllUsersFromDb();
    }
}