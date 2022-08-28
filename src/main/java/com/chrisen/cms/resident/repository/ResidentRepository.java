package com.chrisen.cms.resident.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chrisen.cms.resident.model.Resident;

public interface ResidentRepository extends MongoRepository<Resident, Integer>  {
    List<Resident> findAll();

    Resident findById(String residentId);

    void deleteById(String residentId);
}
