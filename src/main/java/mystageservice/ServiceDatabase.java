package mystageservice;

import lombok.Setter;
import mystageservice.domain.OperaPlay;
import mystageservice.domain.Show;
import mystageservice.domain.TheatrePlay;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static mystageservice.domain.Constants.Language.FRENCH;
@Service
public class ServiceDatabase {

    private List<Show> availableShows = new ArrayList<>();

    public ServiceDatabase() {
        TheatrePlay hunchBack = TheatrePlay.builder()
                .privateTheatre(false).availableBreaks(true)
                .breakDuration(15).name("The HunchBack of NotreDame")
                .duration(120).price(20).maxTickets(100).build();
        TheatrePlay delhiDance = TheatrePlay.builder().privateTheatre(true).availableBreaks(false)
                .duration(90).name("The Delhi Dance").rating(4).numberOfRatings(1).price(45).maxTickets(40).build();
        OperaPlay traviatta = OperaPlay.builder().name("La Traviatta").duration(180).price(70).translationAvailable(true)
                .language(FRENCH).rating(5).numberOfRatings(4).maxTickets(250).build();
        availableShows.add(hunchBack);
        availableShows.add(delhiDance);
        availableShows.add(traviatta);
    }

    public void listShows(){
        for (Show show : availableShows) {
            System.out.println(show.toString());
        }
    }

}
