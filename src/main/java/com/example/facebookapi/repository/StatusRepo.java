package com.example.facebookapi.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.example.facebookapi.entity.Status;

@Repository
public interface StatusRepo extends CassandraRepository<Status, UUID> {
    List<Status> findAll();

    Status save(Status status);
}
