package com.example.facebookapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facebookapi.entity.Post;
import com.example.facebookapi.service.PostService;

@RestController
@RequestMapping("/api/postService")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/save")
    public List<Post> submitPost(@RequestBody Post body) {
        return postService.submitPostToDb(body);

    }

    @GetMapping("/getPost")
    public List<Post> retrieveAllPost() {

        return postService.retrievePostFromDb();

    }

    @DeleteMapping("/delete/{postId}")
    public List<Post> deletePost(@PathVariable UUID postId) {
        return postService.deletePostFromDb(postId);

    }
}