package pl.sda.model;

import javax.persistence.*;

@Entity(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "continentId")
    private Continent continentId;

    public Country(String name, Continent continentId) {
        this.name = name;
        this.continentId = continentId;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinentId() {
        return continentId;
    }

    public void setContinentId(Continent continentId) {
        this.continentId = continentId;
    }
}
