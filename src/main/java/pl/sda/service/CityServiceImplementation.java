package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.City;
import pl.sda.repository.CityRepository;

import java.util.List;

@Service
public class CityServiceImplementation implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City getcityById(Integer id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByNameIgnoreCaseContaining(name);
    }

//    @Override
//    public List<City> getAll() {
//        return cityRepository.findAll();
//    }
@Override
public List<City> getAll() {
    return cityRepository.findAllOrderByName();
}

    @Override
    public List<City> getAllInPoland() {
        return cityRepository.findAllByCountryIdNameEquals("Poland");
    }

    @Override
    public boolean deleteCity(Integer id) {
        try {
            cityRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public City modifyCity(City newCity) {
        return cityRepository.save(newCity);
    }


}
