package pl.sda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.service.ContinentService;
@RequestMapping("/continent")
@RestController
public class ContinentController {
    private final ContinentService continentService;
    public ContinentController(ContinentService continentService){
        this.continentService=continentService;
    }
}
