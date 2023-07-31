package com.example.facebookapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.facebookapi.entity.Status;
import com.example.facebookapi.repository.StatusRepo;

@Service
public class StatusService {
    @Autowired
    private StatusRepo statusRepo;

    public List<Status> submitStatusToDb(Status data) {
        statusRepo.save(data);
        return retrieveStatusFromDb();
    }

    public List<Status> retrieveStatusFromDb() {
        return statusRepo.findAll();
    }

    public List<Status> deletePostFromDb(@PathVariable("statusId") UUID statusId) {
        statusRepo.deleteById(statusId);
        return retrieveStatusFromDb();
    }
}
