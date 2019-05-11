package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.model.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findByNameIgnoreCaseContaining(String name);
    List<City>findAllByCountryIdNameEquals(String name);

    @Query("select city from pl.sda.model.City city order by  city.name")
    List<City>findAllOrderByName();

    @Query("select city.id from pl.sda.model.City city where city.countryId =(select country.id from pl.sda.model.Country country where country.name='Poland') order by  city.name")
    List<City>findCitiesInPoland();
}
