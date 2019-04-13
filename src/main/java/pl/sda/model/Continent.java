package pl.sda.model;

import pl.sda.model.enums.ContinentEnum;

import javax.persistence.*;
import java.util.List;

@Entity(name ="continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public Continent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
