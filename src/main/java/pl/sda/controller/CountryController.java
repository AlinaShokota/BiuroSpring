package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.model.Country;
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
        List<Country>countries=countryService.findByContinent("Africa");
        return ResponseEntity.ok(countries);
    }
}
