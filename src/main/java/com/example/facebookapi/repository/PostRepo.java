package com.example.facebookapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.facebookapi.entity.Post;

@Repository
public interface PostRepo extends CassandraRepository<Post, UUID> {
    List<Post> findAll();

    Post save(Post post);
}
