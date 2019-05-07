package pl.sda.service;

import pl.sda.model.Continent;
import pl.sda.model.Country;

import java.util.List;

public interface CountryService {
    Country addCountry(Country country);
    Country getCountryById(Integer id);
    Country findCountryByName(String name);
    List<Country> getAllCountries();
    boolean deleteCountry(Integer id);
    Country modifyCountry(Country country);
    List<Country>findByContinent(String name);
}
