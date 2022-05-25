package mystageservice.repository;

import mystageservice.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Show findFirstByName(String name);

    List<Show> findAll();

}
