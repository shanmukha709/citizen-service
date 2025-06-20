package com.village.basicinfo.service;

import com.village.area.dto.AreaDTO;
import com.village.area.entity.Area;
import com.village.area.repository.AreaRepository;
import com.village.basicinfo.dto.*;
import com.village.basicinfo.entity.Citizen;
import com.village.basicinfo.feign.DesignationClient;
import com.village.basicinfo.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private DesignationClient designationClient;

    @Override
    public String addCitizen(CitizenDTO request) {
        // Extract username from request (could be passed via frontend or resolved from token)
        String username = request.getUsername(); // Add this in DTO and frontend

        // Check if citizen already exists by username
        Optional<Citizen> existing = citizenRepository.findByUsername(username);

        Citizen citizen = existing.orElse(new Citizen());

        // Set fields (new or overwrite for update)
        citizen.setName(request.getName());
        citizen.setAge(request.getAge());
        citizen.setGender(request.getGender());
        citizen.setUsername(request.getUsername());

        // Map Area
        if (request.getArea() != null) {
            citizen.setAreaId(request.getArea().getId());
        }

        // Map Designation
        if (request.getDesignation() != null) {
            citizen.setDesignationId(request.getDesignation().getId());
        }

        // Save or update citizen
        citizenRepository.save(citizen);

        return existing.isPresent() ? "Profile updated successfully" : "Profile created successfully";
    }

    @Override
    public String updateCitizen(CitizenDTO request) {
        Citizen citizen = citizenRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Citizen not found for username: " + request.getUsername()));

        citizen.setName(request.getName());
        citizen.setAge(request.getAge());
        citizen.setGender(request.getGender());
        citizen.setAreaId(request.getArea().getId());
        citizen.setDesignationId(request.getDesignation().getId());

        citizenRepository.save(citizen);
        return "Citizen updated successfully!";
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen getCitizenById(Long id) {
        return citizenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citizen not found with id " + id));
    }

    @Override
    public void deleteCitizen(Long id) {
        Citizen citizen = getCitizenById(id);
        citizenRepository.delete(citizen);
    }

    @Override
    public CitizenDTO getCitizenWithDesignation(Long id) {
        Citizen citizen = getCitizenById(id);
        DesignationDTO designation = designationClient.getDesignationById(citizen.getDesignationId());

        CitizenDTO dto = new CitizenDTO();
        dto.setId(citizen.getId());
        dto.setName(citizen.getName());
        dto.setAge(citizen.getAge());
        dto.setGender(citizen.getGender());
        dto.setDesignation(designation);

        return dto;
    }

    @Override
    public CitizenWithAreaResponse getCitizenWithArea(Long id) {
        Citizen citizen = getCitizenById(id);
        Area area = areaRepository.findById(citizen.getAreaId())
                .orElseThrow(() -> new RuntimeException("Area not found with ID: " + citizen.getAreaId()));

        return new CitizenWithAreaResponse(
                citizen.getId(),
                citizen.getName(),
                citizen.getAge(),
                citizen.getGender(),
                area.getId(),
                area.getName(),
                area.getAbout()
        );
    }

    @Override
    public CitizenFullResponse getCitizenWithFullDetails(Long id) {
        Citizen citizen = getCitizenById(id);

        Area area = areaRepository.findById(citizen.getAreaId())
                .orElseThrow(() -> new RuntimeException("Area not found"));
        DesignationDTO designation = designationClient.getDesignationById(citizen.getDesignationId());

        return new CitizenFullResponse(
                citizen.getId(),
                citizen.getName(),
                citizen.getAge(),
                citizen.getGender(),
                area.getId(),
                area.getName(),
                area.getAbout(),
                designation.getId(),
                designation.getProfession(),
                designation.getAbout()
        );
    }

    @Override
    public List<CitizenDTO> getCitizensByAreaId(Long areaId) {
        List<Citizen> citizens = citizenRepository.findByAreaId(areaId);
        return citizens.stream().map(citizen -> {
            CitizenDTO dto = new CitizenDTO();
            dto.setId(citizen.getId());
            dto.setName(citizen.getName());
            dto.setAge(citizen.getAge());
            dto.setGender(citizen.getGender());

            // Optionally attach area
            Area area = areaRepository.findById(areaId).orElse(null);
            dto.setArea(area != null ? new AreaDTO(area.getId(), area.getName(), area.getAbout()) : null);

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public CitizenDTO getCitizenByUsername(String username) {
        Citizen citizen = citizenRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Citizen not found with username: " + username));

        Area area = areaRepository.findById(citizen.getAreaId())
                .orElseThrow(() -> new RuntimeException("Area not found with ID: " + citizen.getAreaId()));

        DesignationDTO designation = designationClient.getDesignationById(citizen.getDesignationId());

        CitizenDTO dto = new CitizenDTO();
        dto.setId(citizen.getId());
        dto.setUsername(citizen.getUsername());
        dto.setName(citizen.getName());
        dto.setAge(citizen.getAge());
        dto.setGender(citizen.getGender());
        dto.setArea(new AreaDTO(area.getId(), area.getName(), area.getAbout()));
        dto.setDesignation(designation);

        return dto;
    }
}
