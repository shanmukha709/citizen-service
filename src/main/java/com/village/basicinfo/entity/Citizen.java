package com.village.basicinfo.entity;

import com.village.area.dto.AreaDTO;
import com.village.basicinfo.dto.DesignationDTO;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "citizens")
public class Citizen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String gender;

    private Long areaId;

    private Long designationId;
    @Column(unique = true)
    private String username;

    @Transient
    private AreaDTO area;

    @Transient
    private DesignationDTO designation;

    public Citizen() {
    }

    public Citizen(Long id, String name, int age, String gender, Long areaId, Long designationId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.areaId = areaId;
        this.designationId = designationId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Long getAreaId() {
        return areaId;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public AreaDTO getArea() {
        return area;
    }

    public DesignationDTO getDesignation() {
        return designation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public void setDesignation(DesignationDTO designation) {
        this.designation = designation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
