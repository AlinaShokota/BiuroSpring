package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Country;
import pl.sda.repository.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImplementation implements CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountryById(Integer id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country findCountryByName(String name) {
        return countryRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public boolean deleteCountry(Integer id) {
        try {
            countryRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Country modifyCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findByContinent(String name) {
        return countryRepository.findByContinent(name);
    }
}
