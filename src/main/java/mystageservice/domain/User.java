package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String phoneNumber;
    private String hashPassword;
    private CreditCard creditCard;
    private List<Address> addresses;
    private List<Show> viewedShows;

    public void addRating(float rating, Show show) {
        show.setRating( (show.getRating() * show.getNumberOfRatings() + rating ) /  (show.getNumberOfRatings() + 1) );
    }

}
