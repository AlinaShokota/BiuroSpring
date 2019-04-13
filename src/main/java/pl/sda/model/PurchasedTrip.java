package pl.sda.model;

import javax.persistence.*;

@Entity
public class PurchasedTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip tripId;

    private int amount;
    private String owner;
}
