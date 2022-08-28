package com.chrisen.cms.controller;

import java.util.List;

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
    public List<Resident> getResidents() {
        return residentService.getResidents();
    }

    @PostMapping
    public Resident createResident(@RequestBody Resident resident) {
        return residentService.createResident(resident);
    }

    @GetMapping("/{residentId}")
    public Resident getResident(@PathVariable String residentId) {
        return residentService.getResident(residentId);
    }

    @PutMapping("/{residentId}")
    public Resident updateResident(
        @PathVariable String residentId,
        @RequestBody Resident resident) {
        return residentService.updateResident(residentId, resident);
    }

    @DeleteMapping("/{residentId}")
    public ApiResponse deleteResident( @PathVariable String residentId) {
        return residentService.deleteResident(residentId);
    }
    
}
