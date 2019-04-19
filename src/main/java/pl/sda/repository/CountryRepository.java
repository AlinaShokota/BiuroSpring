package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.Country;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    Country findByNameIgnoreCaseContaining(String name);

    //@Query("select country from pl.sda.model.Country country where country.continentid=(select id from pl.sda.model.Continent continent where continent.name=:name)")

    @Query("select country from pl.sda.model.Country country where country.continentId=(select continent.id from pl.sda.model.Continent continent where continent.continentName=:name)")
    List<Country> findByContinent(@Param("name") String name);

}
