package mystageservice.domain;

import lombok.Builder;

import java.util.Date;
import java.util.List;

public class TheatrePlay extends Show {

    private boolean availableBreaks;
    private boolean privateTheatre;
    private int breakDuration;

    @Builder
    public TheatrePlay(String name, Date date, List<Performer> distribution, List<String> critiquesReviews, float rating, int numberOfRatings, int duration, float price, int maxTickets, boolean availableBreaks, boolean privateTheatre, int breakDuration) {
        super(name, date, distribution, critiquesReviews, rating, numberOfRatings, duration, price, maxTickets);
        this.availableBreaks = availableBreaks;
        this.privateTheatre = privateTheatre;
        this.breakDuration = breakDuration;
    }

    @Override
    public String toString() {
        return "TheatrePlay{" +
                "availableBreaks=" + availableBreaks +
                ", privateTheatre=" + privateTheatre +
                ", breakDuration=" + breakDuration +
                '}';
    }
}
