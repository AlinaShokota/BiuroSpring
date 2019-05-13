package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.controller.model.ImageRequest;
import pl.sda.model.Hotel;
import pl.sda.model.Image;
import pl.sda.model.Trip;
import pl.sda.service.ImageService;
import pl.sda.service.TripService;

import java.util.List;

@RequestMapping("/image")
@RestController
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    TripService tripService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAll(){
        List<Image> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allByTripId")
    public ResponseEntity<List<Image>> getAllByTripId(@RequestParam Integer id){
        List<Image> images = imageService.getImagesByTripId(id);
        return ResponseEntity.ok(images);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public void save(@RequestBody ImageRequest imageRequest){
        Trip trip=tripService.getTripById(imageRequest.getTripId());
        Image image=new Image(imageRequest.getName(),imageRequest.getUrl(),trip);
        image.setId(imageRequest.getId());
        imageService.addImage(image);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveAll")
    public void save(@RequestBody List<ImageRequest> images){
        for (ImageRequest imageRequest : images) {
            Trip trip=tripService.getTripById(imageRequest.getTripId());
            Image image=new Image(imageRequest.getName(),imageRequest.getUrl(),trip);
            image.setId(imageRequest.getId());
            imageService.addImage(image);
        }
    }

}
