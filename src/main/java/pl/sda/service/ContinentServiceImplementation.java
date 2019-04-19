package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Continent;
import pl.sda.repository.ContinentRepository;

import java.util.List;

@Service
public class ContinentServiceImplementation implements ContinentService {
    @Autowired
    ContinentRepository continentRepository;

    @Override
    public Continent addContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    @Override
    public Continent getContinentById(Integer id) {
        return continentRepository.findById(id).get();
    }

    @Override
    public Continent findContinentByName(String name) {
        return continentRepository.findByContinentNameIgnoreCaseContaining(name);
    }

    @Override
    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

    @Override
    public boolean deleteCintinent(Integer id) {
        try {
            continentRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
