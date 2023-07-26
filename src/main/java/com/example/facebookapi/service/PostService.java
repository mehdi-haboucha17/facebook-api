package com.example.facebookapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.facebookapi.entity.Post;
import com.example.facebookapi.repository.PostRepo;

@Service
public class PostService {
    @Autowired
    PostRepo postRepo;

    public List<Post> submitPostToDb(Post data) {
        postRepo.save(data);
        return retrievePostFromDb();
    }

    public List<Post> retrievePostFromDb() {
        return postRepo.findAll();
    }

    public List<Post> deletePostFromDb(@PathVariable("postId") UUID postId) {
        postRepo.deleteById(postId);
        return retrievePostFromDb();
    }
}
