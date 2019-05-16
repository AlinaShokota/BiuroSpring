package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.sda.model.Trip;

import java.util.Date;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip,Integer> {
    @Query("select trip from pl.sda.model.Trip trip where trip.departureDate>current_date")
    List<Trip>findAllTrips();

    @Query("select trip from pl.sda.model.Trip trip where trip.departureDate>current_date and trip.departureDate<(current_date)+7")
    List<Trip>findNearestTrips();

    @Query("select trip from pl.sda.model.Trip trip where trip.promotion>0 and trip.departureDate>current_date")
    List<Trip>findPromotionTrips();

    @Query("select trip from pl.sda.model.Trip trip where trip.cityTo in(select city.id from pl.sda.model.City city where city.countryId=(select country.id from pl.sda.model.Country country where country.name=:name))")
    List<Trip>findTripsByCountry(@Param("name") String name);

    @Query("select trip from pl.sda.model.Trip trip where trip.cityTo in(select city.id from pl.sda.model.City city where city.countryId in(select country.id from pl.sda.model.Country country where country.continentId=(select continent.id from pl.sda.model.Continent continent where continent.continentName=:continentName)))")
    List<Trip>findTripsByContinent2(@Param("continentName") String continentName);

    @Query("select trip from pl.sda.model.Trip trip where trip.countOfDays=:countOfDays")
    List<Trip>findTripsByCountOfDays(@Param("countOfDays") Integer countOfDays);

    @Query("select trip from pl.sda.model.Trip trip where trip.airportFrom=(select airport.id from pl.sda.model.Airport airport where airport.cityId=(select city.id from pl.sda.model.City city where city.name=:name))")
    List<Trip>findTripsByAirportFrom(@Param("name") String name);

    @Query("select trip from pl.sda.model.Trip trip where trip.airportTo=(select airport.id from pl.sda.model.Airport airport where airport.cityId=(select city.id from pl.sda.model.City city where city.name=:name))")
    List<Trip>findTripsByAirportTo(@Param("name") String name);
    @Query("select trip from pl.sda.model.Trip trip where trip.departureDate=:departureDate")
    List<Trip>findTripsByDepartureDate(@Param("departureDate") String departureDate);

}

//    @Query("select trip from pl.sda.model.Trip trip where trip.departureDate>current_date and trip.airportFrom=(select airport from pl.sda.model.Airport airport)")
//    List<Trip>searchTrips(@Param("airportFrom") String airportFrom, @Param("airportTo") String airportTo, @Param("departureDate")String departureDate, @Param("countOfDays") Integer countOfDays);

