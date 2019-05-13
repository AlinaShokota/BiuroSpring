package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.controller.model.HotelRequest;
import pl.sda.model.City;
import pl.sda.model.Country;
import pl.sda.model.Hotel;
import pl.sda.service.ContinentService;
import pl.sda.service.CountryService;

import java.util.List;

@RequestMapping("/country")
@RestController
public class CountryController {
    private final CountryService countryService;
    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }
    @Autowired
    ContinentService continentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAll(){
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/europe")
    public ResponseEntity<List<Country>>getEurope(){
        List<Country>countries=countryService.findByContinent("Europe");
        return ResponseEntity.ok(countries);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/asia")
    public ResponseEntity<List<Country>>getAsia(){
        List<Country>countries=countryService.findByContinent("Asia");
        return ResponseEntity.ok(countries);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/africa")
    public ResponseEntity<List<Country>>getAfrica(){
        List<Country>countries=countryService.findByContinent("Africa");
        return ResponseEntity.ok(countries);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/north-america")
    public ResponseEntity<List<Country>>getNorthAmerica(){
        List<Country>countries=countryService.findByContinent("North America");
        return ResponseEntity.ok(countries);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/south-america")
    public ResponseEntity<List<Country>>getSouthAmerica(){
        List<Country>countries=countryService.findByContinent("North America");
        return ResponseEntity.ok(countries);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/australia")
    public ResponseEntity<List<Country>>getAustralia(){
        List<Country>countries=countryService.findByContinent("Australia");
        return ResponseEntity.ok(countries);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/countries")
    public void save(@RequestBody String name){
        List<Country> countries = countryService.findByContinent(name);
    }


}
