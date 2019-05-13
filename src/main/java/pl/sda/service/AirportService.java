package pl.sda.service;

import pl.sda.model.Airport;

import java.util.List;

public interface AirportService {
    Airport addAirport(Airport airport);
    Airport getAirportById(Integer id);
    Airport getAirportByName(String name);
    List<Airport>getAllAirports();
    List<Airport>getAirportsInPoland();
    List<Airport>getAirportsNotInPoland();
    boolean deleteAirport(Integer id);
    Airport modifyAirport(Airport newAirport);

}
