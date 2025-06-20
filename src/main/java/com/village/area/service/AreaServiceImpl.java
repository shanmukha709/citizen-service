package com.village.area.service;

import com.village.area.dto.AreaDTO;
import com.village.area.entity.Area;
import com.village.area.repository.AreaRepository;
import com.village.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaDTO> getAllAreas() {
        return areaRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AreaDTO getAreaById(Long id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found with ID: " + id));
        return mapToDTO(area);
    }

    @Override
    public AreaDTO createArea(AreaDTO areaDTO) {
        Area area = mapToEntity(areaDTO);
        Area saved = areaRepository.save(area);
        return mapToDTO(saved);
    }

    @Override
    public AreaDTO updateArea(Long id, AreaDTO areaDTO) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found with ID: " + id));

        area.setName(areaDTO.getName());
        area.setAbout(areaDTO.getAbout());

        return mapToDTO(areaRepository.save(area));
    }

    @Override
    public void deleteArea(Long id) {
        areaRepository.deleteById(id);
    }

    // Utility method to convert entity to DTO
    private AreaDTO mapToDTO(Area area) {
        AreaDTO dto = new AreaDTO();
        dto.setId(area.getId());
        dto.setName(area.getName());
        dto.setAbout(area.getAbout());
        return dto;
    }

    // Utility method to convert DTO to entity
    private Area mapToEntity(AreaDTO dto) {
        Area area = new Area();
        area.setId(dto.getId());
        area.setName(dto.getName());
        area.setAbout(dto.getAbout());
        return area;
    }
}
