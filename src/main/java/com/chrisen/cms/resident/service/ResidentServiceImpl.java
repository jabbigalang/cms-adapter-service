package com.chrisen.cms.resident.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chrisen.cms.exception.CmsRecordNotFoundException;
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

        if (oldResident == null) {
            throw new CmsRecordNotFoundException("No record found for id " + residentId);
        }

        resident.setId(oldResident.getId());
        return repository.save(resident);
    }

    @Override
    public void deleteResident(String residentId) {
        Resident resident = repository.findById(residentId);

        if (resident == null) {
            throw new CmsRecordNotFoundException("No record found for id " + residentId);
        }

        repository.deleteById(residentId);
    }
    
}
