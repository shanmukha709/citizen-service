package com.village.basicinfo.dto;

import com.village.area.dto.AreaDTO;
import com.village.basicinfo.dto.DesignationDTO;

public class CitizenDTO {

    private Long id;
    private String name;
    private int age;
    private String gender;
    private Long areaId;
    private Long designationId;
    private AreaDTO area; // full area details (name, about)
    private DesignationDTO designation;// full profession details
    private String username;

    public CitizenDTO() {
    }

    public CitizenDTO(Long id, String name, int age, String gender, AreaDTO area, DesignationDTO designation, Long areaId, Long designationId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.area = area;
        this.designation = designation;
        this.areaId = areaId;
        this.designationId = designationId;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public DesignationDTO getDesignation() {
        return designation;
    }

    public void setDesignation(DesignationDTO designation) {
        this.designation = designation;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
