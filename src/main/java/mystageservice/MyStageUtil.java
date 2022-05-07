package mystageservice;

import mystageservice.domain.Show;

import java.util.Comparator;

public class MyStageUtil {


    public static Comparator<Show> ratingComparator = (o1, o2) -> (int) (o1.getRating() - o2.getRating());

    public static Comparator<Show> popularPerformersComparator = (o1, o2) -> (int) (o1.performersTotalRating() - o2.performersTotalRating());


}
