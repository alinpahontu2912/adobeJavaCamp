package mystageservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Critique extends User {

    private List<Discount> discountList;
    private Date firstReview;
    private int ratingCount;

    @Builder
    public Critique(String name, String phoneNumber, String hashPassword, String creditCard, List<Address> addresses, List<Show> viewedShows, List<Discount> discountList, Date firstReview, int ratingCount) {
        super(name, phoneNumber, hashPassword, creditCard, addresses, viewedShows);
        this.discountList = discountList;
        this.firstReview = firstReview;
        this.ratingCount = ratingCount;
    }

    public Critique(List<Discount> discountList, Date firstReview, int ratingCount) {
        this.discountList = discountList;
        this.firstReview = firstReview;
        this.ratingCount = ratingCount;
    }

    public void addReview(Show show, String review) {
        show.getCritiquesReviews().add(review);
    }

    @Override
    public void addRating(float rating, Show show) {
        show.setRating((show.getRating() * show.getNumberOfRatings() + rating * ratingCount) / (show.getNumberOfRatings() + ratingCount));
    }
}
