package pl.sda.service;



import pl.sda.model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel addHotel(Hotel hotel);
    Hotel getHotelById(Integer id);
    Hotel findHotelByName(String name);
    List<Hotel> getAllHotels();
    List<Hotel> getByCityId(Integer id);
    boolean deleteHotel(Integer id);
    Hotel modifyHotel(Hotel newHotel);
}
