package com.village.basicinfo.dto;

public class CitizenFullResponse {
    private Long id;
    private String name;
    private int age;
    private String gender;

    private Long areaId;
    private String areaName;
    private String areaAbout;

    private Long designationId;
    private String profession;
    private String about;

    public CitizenFullResponse(Long id, String name, int age, String gender,
                               Long areaId, String areaName, String areaAbout,
                               Long designationId, String profession, String about) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.areaId = areaId;
        this.areaName = areaName;
        this.areaAbout = areaAbout;
        this.designationId = designationId;
        this.profession = profession;
        this.about = about;
    }

    // Getters and setters here...


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

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaAbout() {
        return areaAbout;
    }

    public void setAreaAbout(String areaAbout) {
        this.areaAbout = areaAbout;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
