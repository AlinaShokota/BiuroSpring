package pl.sda.controller.JspController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.model.Trip;
import pl.sda.service.TripService;

import java.util.List;

@Controller
public class IndexPage {
    @Autowired
    TripService tripService;

    @GetMapping(value = "/admin")
    public String showAdminPage() {
        return "adminPage";
    }

    @GetMapping(value = "/allTrips")
    public String trips(Model model){
        List<Trip>trips=tripService.getAllTrips();
        model.addAttribute("trips",trips);
        List<Trip>nearestTrips=tripService.getNearestTrips();
        model.addAttribute("nearestTrips",nearestTrips);
        return "allTrips";
    }

}
