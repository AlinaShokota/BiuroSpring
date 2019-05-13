package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.controller.model.HotelRequest;
import pl.sda.controller.model.TripRequest;
import pl.sda.model.Airport;
import pl.sda.model.City;
import pl.sda.model.Hotel;
import pl.sda.model.Trip;
import pl.sda.service.AirportService;
import pl.sda.service.CityService;
import pl.sda.service.HotelService;
import pl.sda.service.TripService;

import javax.xml.bind.ValidationException;
import java.util.List;

@RequestMapping("/trip")
@RestController
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @Autowired
    AirportService airportService;
    @Autowired
    CityService cityService;
    @Autowired
    HotelService hotelService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAll() {
        List<Trip> trips = tripService.getAllTrips();
        return ResponseEntity.ok(trips);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/promotion")
    public ResponseEntity<List<Trip>> getAllPromotion() {
        List<Trip> trips = tripService.getPromotionTrips();
        return ResponseEntity.ok(trips);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/nearest")
    public ResponseEntity<List<Trip>> getNearestTrips() {
        List<Trip> trips = tripService.getNearestTrips();
        return ResponseEntity.ok(trips);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getById")
    public ResponseEntity<Trip> getTripById(@RequestParam Integer id) {
        Trip trip = tripService.getTripById(id);
        return ResponseEntity.ok(trip);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public void save(@RequestBody TripRequest trip) {
        Airport airportFrom = airportService.getAirportById(trip.getAirportFrom());
        Airport airportTo = airportService.getAirportById(trip.getAirportTo());
        Hotel hotel = hotelService.getHotelById(trip.getHotelTo());
        City city = cityService.getcityById(trip.getCityTo());
        Trip trip1 = new Trip(airportFrom, airportTo, hotel, city, trip.getDepartureDate(), trip.getReturnDate(), trip.getCountOfDays(), trip.getType(), trip.getPriceForAdult(), trip.getPriceForChild(), trip.getPromotion(), trip.getCountOfPersons(), trip.getDescription());
        trip1.setId(trip.getId());
        tripService.addTrip(trip1);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findByContinent")
    public ResponseEntity<List<Trip>> getTripsByContinent(@RequestParam String continentName) {
        List<Trip> trips = tripService.getTripsByContinent(continentName);
        return ResponseEntity.ok(trips);
    }
}
