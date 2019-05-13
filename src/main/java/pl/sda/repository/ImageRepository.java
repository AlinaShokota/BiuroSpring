package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.Image;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    @Query("select image from pl.sda.model.Image image where image.tripId.id=:id")
    List<Image> findAllByTripId(@Param("id") Integer id);

}
