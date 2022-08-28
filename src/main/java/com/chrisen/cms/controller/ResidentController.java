package com.chrisen.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chrisen.cms.model.ApiResponse;
import com.chrisen.cms.resident.model.Resident;
import com.chrisen.cms.resident.service.ResidentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/residents")
@AllArgsConstructor
public class ResidentController {

    private ResidentService residentService;

    @GetMapping
    public ResponseEntity<ApiResponse> getResidents() {
        List<Resident> residentList = residentService.getResidents();
        return new ResponseEntity<ApiResponse>(
            new ApiResponse(
                HttpStatus.OK.value(), 
                "Found residents", 
                residentList), 
            HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createResident(@RequestBody Resident resident) {
        Resident createdResident = residentService.createResident(resident);
        return new ResponseEntity<ApiResponse>(
            new ApiResponse(
                HttpStatus.CREATED.value(), 
                "Created resident " + createdResident.getId(), 
                createdResident), 
            HttpStatus.CREATED);
    }

    @GetMapping("/{residentId}")
    public ResponseEntity<ApiResponse> getResident(@PathVariable String residentId) {
        Resident resident = residentService.getResident(residentId);
        return new ResponseEntity<ApiResponse>(
            new ApiResponse(
                HttpStatus.OK.value(), 
                "Found resident " + resident.getId(), 
                resident), 
            HttpStatus.OK);
    }

    @PutMapping("/{residentId}")
    public ResponseEntity<ApiResponse> updateResident(
        @PathVariable String residentId,
        @RequestBody Resident resident) {
        Resident updatedResident = residentService.updateResident(residentId, resident);
        return new ResponseEntity<ApiResponse>(
            new ApiResponse(
                HttpStatus.OK.value(), 
                "Updated resident " + updatedResident.getId(), 
                updatedResident), 
            HttpStatus.OK);
    }

    @DeleteMapping("/{residentId}")
    public ResponseEntity<ApiResponse> deleteResident( @PathVariable String residentId) {
        residentService.deleteResident(residentId);
        return new ResponseEntity<ApiResponse>(
            new ApiResponse(
                HttpStatus.OK.value(), 
                "Deleted resident " + residentId, 
                null), 
            HttpStatus.OK);
    }
    
}
