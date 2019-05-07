package pl.sda.service;


import pl.sda.model.Trip;

import java.util.List;

public interface TripService {
    Trip addTrip(Trip trip);
    Trip getTripById(Integer id);
    List<Trip> getAllTrips();
    boolean deleteTrip(Integer id);
    List<Trip> getNearestTrips();
    List<Trip> getPromotionTrips();
    List<Trip> getTripsEurope();

}
