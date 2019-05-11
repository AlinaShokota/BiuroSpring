package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findByNameIgnoreCaseContaining(String name);

    @Query("select airport from pl.sda.model.Airport airport order by  airport.name")
    List<Airport>findAllOrderByName();

    @Query("select airport from pl.sda.model.Airport airport where airport.cityId in(select city.id from pl.sda.model.City city where city.countryId in(select country.id from pl.sda.model.Country country where country.name='Poland')) order by  airport.name")
    List<Airport>findAirportsInPoland();
}
