package com.village.basicinfo.service;

import com.village.basicinfo.dto.CitizenDTO;
import com.village.basicinfo.dto.CitizenFullResponse;
import com.village.basicinfo.dto.CitizenWithAreaResponse;
import com.village.basicinfo.entity.Citizen;

import java.util.List;

public interface CitizenService {

    String addCitizen(CitizenDTO request);
    List<Citizen> getAllCitizens();
    Citizen getCitizenById(Long id);
    void deleteCitizen(Long id);

    // ⬇️ Returns citizen + only designation
    CitizenDTO getCitizenWithDesignation(Long id);

    // ⬇️ Returns citizen + only area
    CitizenWithAreaResponse getCitizenWithArea(Long id);

    // ⬇️ Full profile: citizen + area + designation
    CitizenFullResponse getCitizenWithFullDetails(Long id);

    // ⬇️ Citizens based on Area
    List<CitizenDTO> getCitizensByAreaId(Long areaId);

    String updateCitizen(CitizenDTO request);

    CitizenDTO getCitizenByUsername(String username);
}
