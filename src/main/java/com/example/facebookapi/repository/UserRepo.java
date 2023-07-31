package com.example.facebookapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.facebookapi.entity.User;

@Repository
public interface UserRepo extends CassandraRepository<User, UUID> {
    List<User> findAll();

    User save(User user);
}
