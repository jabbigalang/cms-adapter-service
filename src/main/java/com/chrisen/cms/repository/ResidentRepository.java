package com.chrisen.cms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chrisen.cms.model.Resident;

public interface ResidentRepository extends MongoRepository<Resident, String> {
    List<Resident> findAll();
    Resident findResidentById(String id);
}
