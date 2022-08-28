package com.chrisen.cms.resident.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chrisen.cms.model.ApiResponse;
import com.chrisen.cms.resident.model.Resident;;

@Component
public interface ResidentService {
    
    List<Resident> getResidents();

    Resident getResident(String residentId);

    Resident createResident(Resident resident);

    Resident updateResident(String residentId, Resident resident);

    ApiResponse deleteResident(String residentId);

}
