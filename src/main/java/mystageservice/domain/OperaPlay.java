package mystageservice.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class OperaPlay extends Show {

    private Enum Language;
    private boolean translationAvailable;

    @Builder
    public OperaPlay(String name, Date date, List<Performer> distribution, List<Review> critiquesReviews, float rating, int numberOfRatings, int duration, float price, int maxTickets, List<User> viewedBy, Long id, Enum language, boolean translationAvailable) {
        super(name, date, distribution, critiquesReviews, rating, numberOfRatings, duration, price, maxTickets, viewedBy, id);
        Language = language;
        this.translationAvailable = translationAvailable;
    }


    @Override
    public String toString() {
        return "OperaPlay{" +
                "Language=" + Language +
                ", translationAvailable=" + translationAvailable +
                '}';
    }
}
