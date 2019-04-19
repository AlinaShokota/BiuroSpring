package pl.sda.model;

import pl.sda.model.enums.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "airportFrom")
    private Airport airportFrom;

    @ManyToOne
    @JoinColumn(name = "airportTo")
    private Airport airportTo;

    @ManyToOne
    @JoinColumn(name = "hotelTo")
    private Hotel hotelTo;

    @ManyToOne
    @JoinColumn(name = "cityTo")
    private City cityTo;

    private Date depatureDate;
    private Date returnDate;
    private int countOfDays;
    private String type;
    private int priceForAdult;
    private int priceForChild;
    private int promotion;
    private int countOfPersons;
    private String description;

    public Trip(){}
    public Trip(Airport airportFrom, Airport airportTo, Hotel hotelTo, City cityTo, Date depatureDate, Date returnDate, int countOfDays, String type, int priceForAdult, int priceForChild, int promotion, int countOfPersons, String description) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.hotelTo = hotelTo;
        this.cityTo = cityTo;
        this.depatureDate = depatureDate;
        this.returnDate = returnDate;
        this.countOfDays = countOfDays;
        this.type = type;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.promotion = promotion;
        this.countOfPersons = countOfPersons;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }

    public Hotel getHotelTo() {
        return hotelTo;
    }

    public void setHotelTo(Hotel hotelTo) {
        this.hotelTo = hotelTo;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public Date getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Date depatureDate) {
        this.depatureDate = depatureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public void setCountOfDays(int countOfDays) {
        this.countOfDays = countOfDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(int priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public int getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(int priceForChild) {
        this.priceForChild = priceForChild;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getCountOfPersons() {
        return countOfPersons;
    }

    public void setCountOfPersons(int countOfPersons) {
        this.countOfPersons = countOfPersons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
