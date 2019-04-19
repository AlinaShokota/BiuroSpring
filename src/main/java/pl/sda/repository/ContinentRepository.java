package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Continent;

@Repository
public interface ContinentRepository extends JpaRepository<Continent,Integer> {
    Continent findByContinentNameIgnoreCaseContaining(String name);
}
