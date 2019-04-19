package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.model.PurchasedTrip;

public interface PurchasedTripRepository extends JpaRepository<PurchasedTrip,Integer> {
    //PurchasedTrip findByNameIgnoreCaseContaining(String name);

}
