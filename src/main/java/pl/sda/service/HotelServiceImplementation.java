package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Hotel;
import pl.sda.repository.HotelRepository;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public Hotel findHotelByName(String name) {
        return hotelRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public boolean deleteHotel(Integer id) {
        try {
            hotelRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
