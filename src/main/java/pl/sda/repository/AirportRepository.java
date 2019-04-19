package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findByNameIgnoreCaseContaining(String name);
}
