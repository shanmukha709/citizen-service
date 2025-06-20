package com.village.area.service;

import com.village.area.dto.AreaDTO;
import java.util.List;

public interface AreaService {
    List<AreaDTO> getAllAreas();
    AreaDTO getAreaById(Long id);
    AreaDTO createArea(AreaDTO areaDTO);       // 🆕 Add area
    AreaDTO updateArea(Long id, AreaDTO areaDTO); // 📝 Update area
    void deleteArea(Long id);                  // ❌ Delete area
}
