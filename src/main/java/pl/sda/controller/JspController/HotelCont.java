package pl.sda.controller.JspController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.model.Airport;
import pl.sda.model.City;
import pl.sda.model.Hotel;
import pl.sda.service.CityService;
import pl.sda.service.HotelService;

import java.util.List;

@Controller
public class HotelCont {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;

    @GetMapping(value = "/addHotel")
    public String showAddAirportForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        List<City> cities = cityService.getAll();
        model.addAttribute("cities",cities);
        List<Hotel>hotels=hotelService.getAllHotels();
        model.addAttribute("hotels",hotels);
        return "addHotel";
    }

    @PostMapping(value = "/saveHotel")
    public String submit(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") String standart,
    @RequestParam(required = false, defaultValue = "") String description,@RequestParam(required = false, defaultValue = "") String city) {
        City city1 = cityService.findByName(city);
        Hotel hotel=new Hotel(name,standart,description,city1);
        hotelService.addHotel(hotel);
        return "redirect:/addHotel";
    }

    @PostMapping(value = "/deleteHotel")
    public String delete(@RequestParam(required = false, defaultValue = "") Integer id){
        hotelService.deleteHotel(id);
        return "redirect:/addHotel";
    }

    @PostMapping(value = "/modifyHotel")
    public String modify(@RequestParam(required = false, defaultValue = "") Integer id,@RequestParam(required = false, defaultValue = "") String city,
                         @RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false) String standart, @RequestParam(required = false) String description){
        Hotel hotel=hotelService.getHotelById(id);
        City city1=cityService.findByName(city);
        hotel.setName(name);
        hotel.setCityId(city1);
        hotel.setStandard(standart);
        hotel.setDescription(description);
        hotelService.modifyHotel(hotel);
        return "redirect:/addHotel";
    }
}
