package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.model.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findByNameIgnoreCaseContaining(String name);

    @Query("select city from pl.sda.model.City city order by  city.name")
    List<City>findAllOrderByName();

}
