package com.example.facebookapi.entity;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Status {
    @PrimaryKey
    private UUID statusId;
    private UUID userId;
    private String statusImageUrl;
    private Instant uploadTimeUrl;

    public Status(UUID statusId, UUID userId, String statusImageUrl, Instant uploadTimeUrl) {
        this.statusId = statusId;
        this.userId = userId;
        this.statusImageUrl = statusImageUrl;
        this.uploadTimeUrl = uploadTimeUrl;
    }

    public UUID getStatusId() {
        return this.statusId;
    }

    public void setStatusId(UUID statusId) {
        this.statusId = statusId;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getStatusImageUrl() {
        return this.statusImageUrl;
    }

    public void setStatusImageUrl(String statusImageUrl) {
        this.statusImageUrl = statusImageUrl;
    }

    public Instant getUploadTimeUrl() {
        return this.uploadTimeUrl;
    }

    public void setUploadTimeUrl(Instant uploadTimeUrl) {
        this.uploadTimeUrl = uploadTimeUrl;
    }

}
