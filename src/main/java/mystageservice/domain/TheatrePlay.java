package mystageservice.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@DiscriminatorValue("2")
public class TheatrePlay extends Show {

    private boolean availableBreaks;
    private boolean privateTheatre;
    private int breakDuration;

    @Builder
    public TheatrePlay(String name, Date date, List<Performer> distribution, List<Review> critiquesReviews, float rating, int numberOfRatings, int duration, float price, int maxTickets, List<User> viewedBy, Long id, boolean availableBreaks, boolean privateTheatre, int breakDuration) {
        super(name, date, distribution, critiquesReviews, rating, numberOfRatings, duration, price, maxTickets, viewedBy, id);
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
