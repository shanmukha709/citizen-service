package com.village.basicinfo.controller;

import com.village.basicinfo.dto.CitizenDTO;
import com.village.basicinfo.dto.CitizenFullResponse;
import com.village.basicinfo.dto.CitizenWithAreaResponse;
import com.village.basicinfo.entity.Citizen;
import com.village.basicinfo.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
@CrossOrigin(origins = "http://localhost:3000")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    // Add a new citizen
    @PostMapping
    public String addCitizen(@RequestBody CitizenDTO request) {
        return citizenService.addCitizen(request);
    }

    // Get all citizens (basic)
    @GetMapping
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    // Get citizen by ID (basic)
    @GetMapping("/{id}")
    public Citizen getCitizenById(@PathVariable Long id) {
        return citizenService.getCitizenById(id);
    }

    // Update citizen
    @PutMapping
    public String updateCitizen(@RequestBody CitizenDTO request) {
        return citizenService.updateCitizen(request);
    }

    // Delete citizen
    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
    }

    // Get citizen with designation info
    @GetMapping("/designation/{id}")
    public CitizenDTO getCitizenWithDesignation(@PathVariable Long id) {
        return citizenService.getCitizenWithDesignation(id);
    }

    // Get citizen with area info
    @GetMapping("/area/{id}")
    public CitizenWithAreaResponse getCitizenWithArea(@PathVariable Long id) {
        return citizenService.getCitizenWithArea(id);
    }

    // Get full details (area + designation)
    @GetMapping("/details/{id}")
    public CitizenFullResponse getCitizenWithFullDetails(@PathVariable Long id) {
        return citizenService.getCitizenWithFullDetails(id);
    }

    // Get all citizens by area ID
    @GetMapping("/by-area/{areaId}")
    public List<CitizenDTO> getCitizensByAreaId(@PathVariable Long areaId) {
        return citizenService.getCitizensByAreaId(areaId);
    }
    @GetMapping("/username/{username}")
    public CitizenDTO getByUsername(@PathVariable String username) {
        return citizenService.getCitizenByUsername(username);
    }
}
