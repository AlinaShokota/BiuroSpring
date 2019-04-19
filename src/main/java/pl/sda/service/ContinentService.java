package pl.sda.service;



import pl.sda.model.Continent;

import java.util.List;

public interface ContinentService {
    Continent addContinent(Continent continent);
    Continent getContinentById(Integer id);
    Continent findContinentByName(String name);
    List<Continent> getAllContinents();
    boolean deleteCintinent(Integer id);
}
