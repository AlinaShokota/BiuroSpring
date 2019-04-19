package pl.sda.controller.JspController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.model.City;
import pl.sda.model.Continent;
import pl.sda.model.Country;
import pl.sda.service.ContinentService;
import pl.sda.service.CountryService;

import java.util.List;

@Controller
public class CountryCont {
    @Autowired
    private CountryService countryService;
    @Autowired
    private ContinentService continentService;

    @GetMapping(value = "/addCountry")
    public String showAddCityForm(Model model) {
        model.addAttribute("country", new Country());
        List<Continent> continents = continentService.getAllContinents();
        model.addAttribute("continents",continents);
        List<Country>countries=countryService.getAllCountries();
        model.addAttribute("countries",countries);
        return "addCountry";
    }

    @PostMapping(value = "/saveCountry")
    public String submit(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") String continent) {
        Continent continent1=continentService.findContinentByName(continent);
        Country country=new Country(name,continent1);
        countryService.addCountry(country);
        return "redirect:/addCountry";
    }
}
