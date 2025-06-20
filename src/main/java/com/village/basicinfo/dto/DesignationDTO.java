package com.village.basicinfo.dto;

public class DesignationDTO {
    private Long id;
    private String profession;
    private String about;

    public DesignationDTO() {
    }

    public DesignationDTO(Long id, String profession, String about) {
        this.id = id;
        this.profession = profession;
        this.about = about;
    }

    public Long getId() {
        return id;
    }

    public String getProfession() {
        return profession;
    }

    public String getAbout() {
        return about;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
