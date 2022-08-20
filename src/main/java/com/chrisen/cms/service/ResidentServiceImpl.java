package com.chrisen.cms.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chrisen.cms.exception.CmsRecordNotFoundException;
import com.chrisen.cms.model.Resident;
import com.chrisen.cms.repository.ResidentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private ResidentRepository residentRepository;

    @Override
    public List<Resident> getResidents() {
        List<Resident> residents = residentRepository.findAll();

        if (residents == null || residents.isEmpty()) {
            throw new CmsRecordNotFoundException("No residents found.");
        }

        return residents;
    }

    @Override
    public Resident getResident(String residentId) {
        Resident resident = residentRepository.findResidentById(residentId);

        if (resident == null) {
            throw new CmsRecordNotFoundException("Resident not found.");
        }

        return resident;
    }

    @Override
    public Resident createResident(Resident resident) {
        Resident newResident = residentRepository.save(resident);

        if (newResident == null) {
            throw new CmsRecordNotFoundException("Failed to create resident.");
        }

        return newResident;
    }

    @Override
    public void deleteResident(String residentId) {
        residentRepository.deleteById(residentId);
    }

    @Override
    public Resident updateResident(Resident resident) {
        Resident updatedResident = residentRepository.save(resident);

        if (updatedResident == null) {
            throw new CmsRecordNotFoundException("Failed to update resident.");
        }

        return updatedResident;
    }
    
}
