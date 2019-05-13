package pl.sda.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelRequest {
    @JsonProperty
    private Integer id;
    private String name;
    private String standard;
    private String description;
    private Integer cityId;

    public HotelRequest(String name, String standard, String description, Integer cityId) {
        this.name = name;
        this.standard = standard;
        this.description = description;
        this.cityId = cityId;
    }

    public HotelRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
