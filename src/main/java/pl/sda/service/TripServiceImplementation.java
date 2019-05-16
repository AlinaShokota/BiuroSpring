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
    public List<Trip> getTripsByContinent(String name) {
        return tripRepository.findTripsByContinent2(name);
    }

    @Override
    public List<Trip> getTripsByCountry(String name) {
        return tripRepository.findTripsByCountry(name);
    }

    @Override
    public List<Trip> getTripsByCountOfDays(Integer countOfDays) {
        return tripRepository.findTripsByCountOfDays(countOfDays);
    }

    @Override
    public List<Trip> getTripsByAirportFrom(String name) {
        return tripRepository.findTripsByAirportFrom(name);
    }
    @Override
    public List<Trip> getTripsByAirportTo(String name) {
        return tripRepository.findTripsByAirportTo(name);
    }

    @Override
    public List<Trip> getTripsByDepartureDate(String departureDate) {
        return tripRepository.findTripsByDepartureDate(departureDate);
    }

    @Override
    public boolean deleteTrip(Integer id) {
        try {
            tripRepository.deleteById(id);
        } catch (Exception e) {
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


}
