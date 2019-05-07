package pl.sda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.model.Airport;
import pl.sda.model.Hotel;
import pl.sda.service.HotelService;

import java.util.List;

@RequestMapping("/hotel")
@RestController
public class HotelController {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }
}
