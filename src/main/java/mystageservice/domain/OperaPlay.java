package mystageservice.domain;

import lombok.Builder;

import java.util.Date;
import java.util.List;

public class OperaPlay extends Show {

    private Enum Language;
    private boolean translationAvailable;

    @Builder
    public OperaPlay(String name, Date date, List<Performer> distribution, List<String> critiquesReviews, float rating, int numberOfRatings, int duration, float price, int maxTickets, Enum language, boolean translationAvailable) {
        super(name, date, distribution, critiquesReviews, rating, numberOfRatings, duration, price, maxTickets);
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
