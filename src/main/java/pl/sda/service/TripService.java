package pl.sda.service;


import pl.sda.model.Trip;

import java.util.List;

public interface TripService {
    Trip addTrip(Trip trip);
    Trip getTripById(Integer id);
    List<Trip> getAllTrips();
    List<Trip> getTripsByContinent(String name);
    List<Trip> getTripsByCountry(String name);
    List<Trip> getTripsByCountOfDays(Integer countOfDays);
    List<Trip> getTripsByAirportFrom(String name);
    List<Trip> getTripsByAirportTo(String name);
    List<Trip> getTripsByDepartureDate(String departureDate);
    boolean deleteTrip(Integer id);
    List<Trip> getNearestTrips();
    List<Trip> getPromotionTrips();

}
