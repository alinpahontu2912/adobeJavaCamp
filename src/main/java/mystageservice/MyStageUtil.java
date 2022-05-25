package mystageservice;

import mystageservice.domain.Performer;
import mystageservice.domain.Show;

import java.util.Collections;
import java.util.Comparator;

public class MyStageUtil {
    public static String catApi = "https://catfact.ninja/fact";

    public static String catApiKey = "fact";

    // search by title
    public static String movieApi = "http://www.omdbapi.com/?apikey=38aa54b0&t=";

    public static Comparator<Show> ratingComparator = Comparator.comparing(Show::getRating);

    public static Comparator<Show> critiquesCountComparator = (o1, o2) -> (int) (o1.getCritiquesReviews().size() - o2.getCritiquesReviews().size());

    public static Comparator<Show> popularPerformersComparator = (o1, o2) -> (int) (o1.performersTotalRating() - o2.performersTotalRating());

    public static Comparator<Performer> performerRatingComparator = Comparator.comparing(Performer::getRating, Collections.reverseOrder());

    public static Comparator<Performer> performerNameComparator = Comparator.comparing(Performer::getName);

    public static Comparator<Performer> performerAgeComparator = Comparator.comparing(Performer::getAge);
}
