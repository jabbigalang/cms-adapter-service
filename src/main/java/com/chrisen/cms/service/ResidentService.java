package com.chrisen.cms.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chrisen.cms.model.Resident;

@Component
public interface ResidentService {

    List<Resident> getResidents();

    Resident getResident(String residentId);

    Resident createResident(Resident resident);

    void deleteResident(String residentId);

    Resident updateResident(Resident resident);
}
