package com.chrisen.cms.resident.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chrisen.cms.model.ApiResponse;
import com.chrisen.cms.resident.model.Resident;
import com.chrisen.cms.resident.repository.ResidentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ResidentServiceImpl implements ResidentService {

    private ResidentRepository repository;

    @Override
    public List<Resident> getResidents() {
        return repository.findAll();
    }

    @Override
    public Resident getResident(String residentId) {
        return repository.findById(residentId);
    }

    @Override
    public Resident createResident(Resident resident) {
        return repository.save(resident);
    }

    @Override
    public Resident updateResident(String residentId, Resident resident) {
        Resident oldResident = repository.findById(residentId);
        resident.setId(oldResident.getId());
        return repository.save(resident);
    }

    @Override
    public ApiResponse deleteResident(String residentId) {
        repository.deleteById(residentId);
        return null;
    }
    
}
