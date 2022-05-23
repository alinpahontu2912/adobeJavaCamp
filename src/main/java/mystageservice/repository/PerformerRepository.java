package mystageservice.repository;

import mystageservice.domain.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {
    Performer findFirstByName(String name);

    List<Performer> findAll();
}
