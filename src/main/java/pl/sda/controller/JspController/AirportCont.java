package pl.sda.controller.JspController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sda.model.Airport;
import pl.sda.model.City;
import pl.sda.service.AirportService;
import pl.sda.service.CityService;

import java.util.List;


@Controller
public class AirportCont {

    @Autowired
    private AirportService airportService;
    @Autowired
    private CityService cityService;

    @GetMapping(value = "/addAirport")
    public String showAddAirportForm(Model model) {
        model.addAttribute("airport", new Airport());
        List<City> cities = cityService.getAll();
        model.addAttribute("cities",cities);
        List<Airport>airports=airportService.getAllAirports();
        model.addAttribute("airports",airports);
        return "addAirport";
    }

    @PostMapping(value = "/saveAirport")
    public String submit(Model model, @RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") String city) {
        City city1 = cityService.findByName(city);
        Airport airport=new Airport(name,city1);
        airportService.addAirport(airport);
        return "redirect:/addAirport";
    }

    @PostMapping(value = "/deleteAirport")
    public String delete(@RequestParam(required = false, defaultValue = "") Integer id){
        airportService.deleteAirport(id);
        return "redirect:/addAirport";
    }

    @PostMapping(value = "/modifyAirport")
    public String modify(@RequestParam(required = false, defaultValue = "") Integer id,@RequestParam(required = false, defaultValue = "") String city,
                         @RequestParam(required = false, defaultValue = "") String name){
        Airport airport=airportService.getAirportById(id);
        City city1=cityService.findByName(city);
        airport.setName(name);
        airport.setCityId(city1);
        airportService.modifyAirport(airport);
        return "redirect:/addAirport";
    }
//    @GetMapping(value = "/all-airports")
//    public String allAirports(Model model){
//        List<Airport>airports=airportService.getAllAirports();
//        model.addAttribute("airports",airports);
//        List<City> cities = cityService.getAll();
//        model.addAttribute("cities",cities);
//        return "addAirport";
//    }

}
