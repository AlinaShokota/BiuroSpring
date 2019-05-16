package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.controller.model.HotelRequest;
import pl.sda.model.Airport;
import pl.sda.model.City;
import pl.sda.model.Hotel;
import pl.sda.service.CityService;
import pl.sda.service.HotelService;

import javax.xml.bind.ValidationException;
import java.util.List;

@RequestMapping("/hotel")
@RestController
public class HotelController {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }
    @Autowired
    private CityService cityService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public void save(@RequestBody HotelRequest hotel){
        City city=cityService.getcityById(hotel.getCityId());
        Hotel hotel1=new Hotel(hotel.getName(),hotel.getStandard(),hotel.getDescription(),city);
        hotel1.setId(hotel.getId());
        hotelService.addHotel(hotel1);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getHotel")
    public ResponseEntity<Hotel> getHotel(@RequestParam Integer id){
        Hotel hotel=hotelService.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allByCityId")
    public ResponseEntity<List<Hotel>> getAllByCityId(@RequestParam Integer id){
        List<Hotel> hotels = hotelService.getByCityId(id);
        return ResponseEntity.ok(hotels);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete")
    public void delete(@RequestBody Integer id){
        hotelService.deleteHotel(id);
    }


}
