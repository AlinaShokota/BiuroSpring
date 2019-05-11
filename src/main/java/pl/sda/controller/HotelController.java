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
    @PostMapping("/feedback")
    public void sendFeedback(@RequestBody HotelRequest hotelRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            try {
                throw new ValidationException("Feedback had errors");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
        City city=cityService.findByName(hotelRequest.getCityName());
        Hotel hotel=new Hotel(hotelRequest.getName(),hotelRequest.getStandard(), hotelRequest.getDescription(), city);
        this.hotelService.addHotel(hotel);
    }

}
