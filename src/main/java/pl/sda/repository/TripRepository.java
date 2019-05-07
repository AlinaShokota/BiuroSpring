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

    //@Query("select trip from pl.sda.model.Trip trip where trip.cityTo in(select city.id from pl.sda.model.City city where city.name='Paris')")
    @Query("select trip from pl.sda.model.Trip trip where trip.cityTo in(select city.id from pl.sda.model.City city where city.countryId in(select country.id from pl.sda.model.Country country where country.continentId=(select continent.id from pl.sda.model.Continent continent where continent.continentName='Asia')))")
    List<Trip>findTripsEurope();


}
