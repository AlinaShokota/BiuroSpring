package pl.sda.controller.JspController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.model.Airport;
import pl.sda.model.City;
import pl.sda.model.Country;
import pl.sda.service.CityService;
import pl.sda.service.CountryService;

import java.util.List;

@Controller
public class CityCont {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/addCity")
    public String showAddCityForm(Model model) {
        model.addAttribute("city", new City());
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries",countries);
        List<City>cities=cityService.getAll();
        model.addAttribute("cities",cities);
        return "addCity";
    }

    @PostMapping(value = "/saveCity")
    public String submit(Model model, @RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") String country) {
        Country country1=countryService.findCountryByName(country);
        City city=new City(name,country1);
        cityService.addCity(city);
        return "redirect:/addCity";
    }
    @PostMapping(value = "/deleteCity")
    public String delete(@RequestParam(required = false, defaultValue = "") Integer id){
        cityService.deleteCity(id);
        return "redirect:/addCity";
    }

    @PostMapping(value = "/modifyCity")
    public String modify(@RequestParam(required = false, defaultValue = "") Integer id,@RequestParam(required = false, defaultValue = "") String country,
                         @RequestParam(required = false, defaultValue = "") String name){
        City city=cityService.getcityById(id);
        Country country1=countryService.findCountryByName(country);
        city.setName(name);
        city.setCountryId(country1);
        cityService.modifyCity(city);
        return "redirect:/addCity";
    }
//    @GetMapping(value = "/allCities")
//    public String allAirports(Model model){
//        List<City>cities=cityService.getAll();
//        model.addAttribute("cities",cities);
//        List<Country>countries=countryService.getAllCountries();
//        model.addAttribute("countries",countries);
//        return "cities";
//    }
}
