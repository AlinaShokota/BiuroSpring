package pl.sda.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelRequest {
    @JsonProperty
    private Long id;
    private String name;
    private String standard;
    private String description;
    private String cityName;

    public HotelRequest(String name, String standard, String description, String cityName) {
        this.name = name;
        this.standard = standard;
        this.description = description;
        this.cityName = cityName;
    }

    public HotelRequest() {
    }

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
