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
import pl.sda.model.Trip;
import pl.sda.service.AirportService;
import pl.sda.service.CityService;
import pl.sda.service.HotelService;
import pl.sda.service.TripService;

import java.util.Date;
import java.util.List;

@Controller
public class TripCont {
    @Autowired
    private TripService tripService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;

    @GetMapping(value = "/addTrip")
    public String showAddTripForm(Model model) {
        model.addAttribute("trip", new Trip());
        List<Trip>trips=tripService.getAllTrips();
        model.addAttribute("trips",trips);
        List<Airport>airportsFrom=airportService.getAirportsInPoland();
        model.addAttribute("airportsFrom",airportsFrom);
        List<Airport>airports=airportService.getAllAirports();
        model.addAttribute("airports",airports);
        List<Hotel>hotels=hotelService.getAllHotels();
        model.addAttribute("hotels",hotels);
        List<City>cities=cityService.getAll();
        model.addAttribute("cities",cities);
        return "addTrip";
    }

    @PostMapping(value = "/saveTrip")
    public String submit(@RequestParam(required = false, defaultValue = "") String airportFrom, @RequestParam(required = false, defaultValue = "") String airportTo,
                         @RequestParam(required = false, defaultValue = "") String hotelTo, @RequestParam(required = false, defaultValue = "") String cityTo,
                         @RequestParam(required = false, defaultValue = "") String departureDate, @RequestParam(required = false, defaultValue = "") String returnDate,
                         @RequestParam(required = false, defaultValue = "") int countOfDays,@RequestParam(required = false, defaultValue = "") String type,
                         @RequestParam(required = false, defaultValue = "") int priceForAdult,@RequestParam(required = false, defaultValue = "") int priceForChild,
                         @RequestParam(required = false, defaultValue = "") int promotion, @RequestParam(required = false, defaultValue = "") int countOfPersons,
                         @RequestParam(required = false, defaultValue = "") String description) {
        //Airport airportFrom1=airportService.getAirportByName(airportFrom);
        Airport airportFrom1=airportService.getAirportByName(airportFrom);
        Airport airportTo1=airportService.getAirportByName(airportTo);
        Hotel hotelTo1=hotelService.findHotelByName(hotelTo);
        City cityTo1=cityService.findByName(cityTo);
        Trip trip=new Trip(airportFrom1,airportTo1,hotelTo1,cityTo1,departureDate,returnDate,countOfDays,type,priceForAdult,priceForChild,promotion,countOfPersons,description);
        tripService.addTrip(trip);
        return "redirect:/addTrip";

    }
}
