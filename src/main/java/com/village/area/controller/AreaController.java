package com.village.area.controller;

import com.village.area.dto.AreaDTO;
import com.village.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {
        "https://our-circle-ui.onrender.com",
        "http://localhost:3000"
})
@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    // GET all areas
    @GetMapping
    public List<AreaDTO> getAllAreas() {
        return areaService.getAllAreas();
    }

    // GET area by ID
    @GetMapping("/{id}")
    public AreaDTO getAreaById(@PathVariable Long id) {
        return areaService.getAreaById(id);
    }

    // POST new area
    @PostMapping
    public AreaDTO createArea(@RequestBody AreaDTO areaDTO) {
        return areaService.createArea(areaDTO);
    }

    // PUT update area
    @PutMapping("/{id}")
    public AreaDTO updateArea(@PathVariable Long id, @RequestBody AreaDTO areaDTO) {
        return areaService.updateArea(id, areaDTO);
    }

    // DELETE area
    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable Long id) {
        areaService.deleteArea(id);
    }
}
