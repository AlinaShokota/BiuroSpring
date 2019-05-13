package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Image;
import pl.sda.repository.ImageRepository;

import java.util.List;

@Service
public class ImageServiceImplementation implements ImageService {
@Autowired
    ImageRepository imageRepository;

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByTripId(Integer id) {
        return imageRepository.findAllByTripId(id);
    }

    @Override
    public Image getImageById(Integer id) {
        return imageRepository.findById(id).get();
    }
}
