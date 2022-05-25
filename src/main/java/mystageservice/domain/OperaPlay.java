package mystageservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class OperaPlay extends Show {

    private String Language;
    private boolean translationAvailable;

    @Builder
    public OperaPlay(String name, Date date, List<Performer> distribution, List<Review> critiquesReviews, float rating,
                     int numberOfRatings, int duration, float price, int maxTickets, List<User> viewedBy, Long id,
                     String language, boolean translationAvailable) {
        super(name, date, distribution, critiquesReviews, rating, numberOfRatings, duration, price, maxTickets, viewedBy, id);
        this.Language = language;
        this.translationAvailable = translationAvailable;
    }

}
