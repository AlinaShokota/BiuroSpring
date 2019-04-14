package pl.sda.model;

import javax.persistence.*;

@Entity
public class PurchasedTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip tripId;

    private int amount;
    private String owner;

    public PurchasedTrip(Trip tripId, int amount, String owner) {
        this.tripId = tripId;
        this.amount = amount;
        this.owner = owner;
    }

    public PurchasedTrip() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
