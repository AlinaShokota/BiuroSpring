package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.controller.model.AirportRequest;
import pl.sda.model.Airport;
import pl.sda.model.City;
import pl.sda.service.AirportService;
import pl.sda.service.CityService;

import java.util.List;

@RequestMapping("/airport")
@RestController
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @Autowired
    private CityService cityService;

    @PostMapping("/save")
    public ResponseEntity<Airport> save(@RequestBody AirportRequest airportRequest) {
        City city = cityService.findByName(airportRequest.getCityName());
        Airport airport = new Airport(airportRequest.getName(), city);
        airportService.addAirport(airport);
        return ResponseEntity.ok(airport);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Airport>> getAll(){
        List<Airport> airports = airportService.getAllAirports();
        return ResponseEntity.ok(airports);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/airportsInPoland")
    public ResponseEntity<List<Airport>> getAirportsInPoland(){
        List<Airport> airports = airportService.getAirportsInPoland();
        return ResponseEntity.ok(airports);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/airportsNotInPoland")
    public ResponseEntity<List<Airport>> getAirportsNotInPoland(){
        List<Airport> airports = airportService.getAirportsNotInPoland();
        return ResponseEntity.ok(airports);
    }

}
