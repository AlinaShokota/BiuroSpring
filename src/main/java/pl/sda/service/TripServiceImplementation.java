package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Trip;
import pl.sda.repository.TripRepository;

import java.util.List;

@Service
public class TripServiceImplementation implements TripService {
    @Autowired
    TripRepository tripRepository;

    @Override
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTripById(Integer id) {
        return tripRepository.findById(id).get();
    }


    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAllTrips();
    }

    @Override
    public boolean deleteTrip(Integer id) {
        try {
            tripRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Trip> getNearestTrips() {
        return tripRepository.findNearestTrips();
    }

    @Override
    public List<Trip> getPromotionTrips() {
        return tripRepository.findPromotionTrips();
    }

    @Override
    public List<Trip> getTripsEurope() {
        return tripRepository.findTripsEurope();
    }
}
