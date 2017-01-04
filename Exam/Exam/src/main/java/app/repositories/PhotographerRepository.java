package app.repositories;

import app.domain.models.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long> {

    Photographer findByFirstNameAndLastName(String trainerFirstName, String trainerLastName);

    @Query(value = "SELECT p FROM Photographer AS p " +
            "ORDER BY p.firstName ASC , p.lastName DESC ")
    List<Photographer> findAllOrderByFirstNameAscLastNameDesc();

    @Query(
            nativeQuery = true,
            value = "SELECT\n" +
                    "  p.first_name,\n" +
                    "  p.last_name,\n" +
                    "  c.make,\n" +
                    "  COUNT(l.id)\n" +
                    "FROM photographers AS p\n" +
                    "INNER JOIN cameras AS c\n" +
                    "ON p.primary_camera_id = c.id\n" +
                    "INNER JOIN lenses AS l\n" +
                    "ON p.id = l.owner_id\n" +
                    "WHERE c.type = \"DSLR\"\n" +
                    "AND l.focal_length <= 30\n" +
                    "GROUP BY p.id\n" +
                    "ORDER BY p.first_name ASC"
    )
    List<Object[]> findLandscapePhotographers();
}