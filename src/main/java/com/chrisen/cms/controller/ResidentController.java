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
import com.chrisen.cms.model.Resident;
import com.chrisen.cms.service.ResidentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/residents")
@AllArgsConstructor
public class ResidentController {

    private ResidentService residentService;

    @GetMapping
    public ResponseEntity<ApiResponse> getResidents() {
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Residents found.", residentService.getResidents()), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createResident(@RequestBody Resident resident) {
        return new ResponseEntity<>(new ApiResponse(HttpStatus.CREATED, "Resident created.", residentService.createResident(resident)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateResident(@RequestBody Resident resident) {
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Resident updated.", residentService.updateResident(resident)), HttpStatus.OK);
    }

    @GetMapping("/{residentId}")
    public ResponseEntity<ApiResponse> getResident(@PathVariable String residentId) {
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Resident found.", residentService.getResident(residentId)), HttpStatus.OK);
    }

    @DeleteMapping("/{residentId}")
    public ResponseEntity<ApiResponse> deleteResident(@PathVariable String residentId) {
        residentService.deleteResident(residentId);

        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Resident deleted."), HttpStatus.OK);
    }

}
