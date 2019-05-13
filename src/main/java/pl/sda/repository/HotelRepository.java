package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    Hotel findByNameIgnoreCaseContaining(String name);

    @Query("select hotel from pl.sda.model.Hotel hotel where hotel.cityId.id=:id")
    List<Hotel> findByCityId(@Param("id") Integer id);

}
