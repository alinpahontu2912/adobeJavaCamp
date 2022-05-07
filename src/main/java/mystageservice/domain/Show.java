package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    private String name;
    private Date date;
    private List<Performer> distribution;
    private List<String> critiquesReviews;
    private float rating;
    private int numberOfRatings;
    private int duration;
    private float price;
    private int maxTickets;

    public float performersTotalRating() {
        float sum = 0;
        for (Performer performer : distribution) {
            sum += performer.getRating();
        }
        sum /= distribution.size();
        return sum;
    }

    ;

    @Override
    public String toString() {
        return "Show{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", distribution=" + distribution +
                ", critiquesReviews=" + critiquesReviews +
                ", rating=" + rating +
                ", numberOfRatings=" + numberOfRatings +
                ", duration=" + duration +
                ", price=" + price +
                ", maxTickets=" + maxTickets +
                '}';
    }
}
