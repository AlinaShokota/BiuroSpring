package pl.sda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.model.City;
import pl.sda.model.Continent;
import pl.sda.service.ContinentService;

import java.util.List;

@RequestMapping("/continent")
@RestController
public class ContinentController {
    private final ContinentService continentService;
    public ContinentController(ContinentService continentService){
        this.continentService=continentService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Continent>> getAll(){
        List<Continent> continents = continentService.getAllContinents();
        return ResponseEntity.ok(continents);
    }
}
