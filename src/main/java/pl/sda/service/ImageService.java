package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Image;
import pl.sda.repository.ImageRepository;

import java.util.List;

public interface ImageService {
    Image addImage(Image image);
    List<Image> getAllImages();
    List<Image> getImagesByTripId(Integer id);
    Image getImageById(Integer id);
}
