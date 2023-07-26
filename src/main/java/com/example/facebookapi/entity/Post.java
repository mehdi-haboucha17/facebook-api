package com.example.facebookapi.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Table
public class Post {

    @PrimaryKey
    private UUID postId;
    private UUID userId;
    private String userName;
    private String imageUrl;
    private String description;
    private String postImgUrl;
    private int likes;
    private Instant dataTime;

    public Post() {
        super();
    }

    public UUID getPostId() {
        return this.postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostImgUrl() {
        return this.postImgUrl;
    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Instant getDataTime() {
        return this.dataTime;
    }

    public void setDataTime(Instant dataTime) {
        this.dataTime = dataTime;
    }

}
