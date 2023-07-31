package com.example.facebookapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.facebookapi.entity.Status;
import com.example.facebookapi.service.StatusService;

@RestController
@RequestMapping("/api/statusService")
public class StatusController {
    @Autowired
    StatusService statusService;

    @PostMapping("/save")
    public List<Status> submitPost(@RequestBody Status body) {
        return statusService.submitStatusToDb(body);

    }

    @GetMapping("/getStatus")
    public List<Status> retrieveAllStatus() {

        return statusService.retrieveStatusFromDb();

    }

    @DeleteMapping("/delete/{StatusId}")
    public List<Status> deleteStatus(@PathVariable UUID statusId) {
        return statusService.deletePostFromDb(statusId);

    }
}
