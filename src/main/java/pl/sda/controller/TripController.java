package pl.sda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.model.Hotel;
import pl.sda.model.Trip;
import pl.sda.service.TripService;

import java.util.List;

@RequestMapping("/trip")
@RestController
public class TripController {
    private final TripService tripService;
    public TripController(TripService tripService){
        this.tripService=tripService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAll(){
        List<Trip> trips = tripService.getAllTrips();
        return ResponseEntity.ok(trips);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/promotion")
    public ResponseEntity<List<Trip>> getAllPromotion(){
        List<Trip> trips = tripService.getPromotionTrips();
        return ResponseEntity.ok(trips);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/nearest")
    public ResponseEntity<List<Trip>> getNearestTrips(){
        List<Trip> trips = tripService.getNearestTrips();
        return ResponseEntity.ok(trips);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/europe")
    public ResponseEntity<List<Trip>> getTripsEurope(){
        List<Trip> trips = tripService.getTripsEurope();
        return ResponseEntity.ok(trips);
    }
}
