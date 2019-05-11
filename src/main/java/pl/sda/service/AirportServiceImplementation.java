package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Airport;
import pl.sda.repository.AirportRepository;

import java.util.List;

@Service
public class AirportServiceImplementation implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport getAirportById(Integer id) {
        return airportRepository.findById(id).get();
    }

    @Override
    public Airport getAirportByName(String name) {
        return airportRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAllOrderByName();
    }

    @Override
    public List<Airport> getAirportsInPoland() {
        return airportRepository.findAirportsInPoland();
    }

    @Override
    public boolean deleteAirport(Integer id) {
        try {
            airportRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Airport modifyAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }


}
