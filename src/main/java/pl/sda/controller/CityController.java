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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public void save(@RequestBody CityRequest cityRequest) {
        Country country=countryService.getCountryById(cityRequest.getCountryId());
        City city=new City(cityRequest.getName(),country);
        city.setId(cityRequest.getId());
        cityService.addCity(city);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<City>> getAll(){
        List<City> cities = cityService.getAll();
        return ResponseEntity.ok(cities);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/in-Poland")
    public ResponseEntity<List<City>> getAllInPoland(){
        List<City> cities = cityService.getAllInPoland();
        return ResponseEntity.ok(cities);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete")
    public void save(@RequestBody Integer id){
        cityService.deleteCity(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getCity")
    public ResponseEntity<City> getCity(@RequestParam Integer id){
        City city=cityService.getcityById(id);
        return ResponseEntity.ok(city);
    }
}
