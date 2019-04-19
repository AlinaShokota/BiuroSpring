package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.controller.model.CityRequest;
import pl.sda.model.City;
import pl.sda.model.Country;
import pl.sda.service.CityService;
import pl.sda.service.CountryService;

import java.util.List;

@RequestMapping("/city")
@RestController
public class CityController {
    private final CityService cityService;
    public CityController(CityService cityService){
        this.cityService=cityService;
    }
    @Autowired
    CountryService countryService;

    @PostMapping("/save")
    public ResponseEntity<City> save(@RequestBody CityRequest cityRequest) {
        Country country=countryService.findCountryByName(cityRequest.getName());
        City city=new City(cityRequest.getName(),country);
        cityService.addCity(city);
        return ResponseEntity.ok(city);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<City>> getAll(){
        List<City> cities = cityService.getAll();
        return ResponseEntity.ok(cities);
    }
}
