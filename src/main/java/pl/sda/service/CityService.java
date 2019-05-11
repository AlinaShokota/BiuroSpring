package pl.sda.service;

import pl.sda.model.City;

import java.util.List;

public interface CityService {
    City addCity(City city);
    City getcityById(Integer id);
    City findByName(String name);
    List<City>getAll();
    List<City>getAllInPoland();
    boolean deleteCity(Integer id);
    City modifyCity(City newCity);
}
