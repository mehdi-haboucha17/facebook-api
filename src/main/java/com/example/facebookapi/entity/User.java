package com.example.facebookapi.entity;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
    @PrimaryKey
    private UUID userId;

    private String userName;
    private String userImageUrl;
    private String activString;
    private Instant joinedDate;

    public User() {
        super();
    }

    public User(UUID userId, String userName, String userImageUrl, String activString, Instant joinedDate) {
        this.userId = userId;
        this.userName = userName;
        this.userImageUrl = userImageUrl;
        this.activString = activString;
        this.joinedDate = joinedDate;
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

    public String getUserImageUrl() {
        return this.userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getActivString() {
        return this.activString;
    }

    public void setActivString(String activString) {
        this.activString = activString;
    }

    public Instant getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(Instant joinedDate) {
        this.joinedDate = joinedDate;
    }

}
