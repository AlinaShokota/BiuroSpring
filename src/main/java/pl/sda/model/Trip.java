package pl.sda.model;

import pl.sda.model.enums.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    private Type type;
    private int priceForAdult;
    private int priceForChild;
    private int promotion;
    private int countOfPersons;
    private String description;
}
