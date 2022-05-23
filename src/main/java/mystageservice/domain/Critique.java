package mystageservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class Critique extends User {

    private Date firstReview;
    private int ratingCount;

    @OneToMany(mappedBy = "critique")
    private List<Review> reviewsList;

    @Builder
    public Critique(Long id, String name, String phoneNumber, String hashPassword, CreditCard creditCard, List<Address> addresses, List<Show> viewedShows, Date firstReview, int ratingCount, List<Review> reviewsList) {
        super(id, name, phoneNumber, hashPassword, creditCard, addresses, viewedShows);
        this.firstReview = firstReview;
        this.ratingCount = ratingCount;
        this.reviewsList = reviewsList;
    }

    @Override
    public void addRating(float rating, Show show) {
        show.setRating((show.getRating() * show.getNumberOfRatings() + rating * ratingCount) / (show.getNumberOfRatings() + ratingCount));
    }

    public void addReview(String review, Show show) {
        Review newReview = new Review.ReviewBuilder().critique(this).review(review).show(show).build();
        show.getCritiquesReviews().add(newReview);
    }
}
