package pl.sda.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryRequest {
    @JsonProperty
    private Integer id;
    private String name;
    private String imageUrl;
    private Integer continentId;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
