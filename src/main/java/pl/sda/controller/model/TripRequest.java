package pl.sda.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TripRequest {
    @JsonProperty
    private Integer id;
    private Integer airportFrom;
    private Integer airportTo;
    private Integer hotelTo;
    private Integer cityTo;
    private String departureDate;
    private String returnDate;
    private Integer countOfDays;
    private String type;
    private Integer priceForAdult;
    private Integer priceForChild;
    private Integer promotion;
    private Integer countOfPersons;
    private String description;

    public TripRequest(Integer id, Integer airportFrom, Integer airportTo, Integer hotelTo, Integer cityTo, String departureDate, String returnDate, Integer countOfDays, String type, Integer priceForAdult, Integer priceForChild, Integer promotion, Integer countOfPersons, String description) {
        this.id = id;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.hotelTo = hotelTo;
        this.cityTo = cityTo;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.countOfDays = countOfDays;
        this.type = type;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.promotion = promotion;
        this.countOfPersons = countOfPersons;
        this.description = description;
    }

    public TripRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Integer airportFrom) {
        this.airportFrom = airportFrom;
    }

    public Integer getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(Integer airportTo) {
        this.airportTo = airportTo;
    }

    public Integer getHotelTo() {
        return hotelTo;
    }

    public void setHotelTo(Integer hotelTo) {
        this.hotelTo = hotelTo;
    }

    public Integer getCityTo() {
        return cityTo;
    }

    public void setCityTo(Integer cityTo) {
        this.cityTo = cityTo;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getCountOfDays() {
        return countOfDays;
    }

    public void setCountOfDays(Integer countOfDays) {
        this.countOfDays = countOfDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(Integer priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public Integer getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(Integer priceForChild) {
        this.priceForChild = priceForChild;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Integer getCountOfPersons() {
        return countOfPersons;
    }

    public void setCountOfPersons(Integer countOfPersons) {
        this.countOfPersons = countOfPersons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
