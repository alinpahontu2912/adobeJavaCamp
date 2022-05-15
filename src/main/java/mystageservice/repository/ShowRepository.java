package mystageservice.repository;

import mystageservice.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findAll();

    @Query(value = "SELECT show from Show show WHERE show.maxTickets > 0 ORDER BY show.name")
    List<Show> findAvailableShows();

    @Modifying
    @Query(value = "INSERT INTO Show (show_type, name, date,rating, numberOfRatings, duration, price, maxTickets) VALUES (?1 ?2 ?3 ?4 ?5 ?6 ?7 ?8)", nativeQuery = true)
    void insertShow(int show_type, String name, Date date, float rating, int numberOfRatings, int duration, float price, int maxTickets);
}
