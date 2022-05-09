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
        show.setRating((show.getRating() * show.getNumberOfRatings() + rating) / (show.getNumberOfRatings() + 1));
    }

    public boolean buyTicket(Show show, int numberOfTickets) {
        if (creditCard.isAccepted() && show.getMaxTickets() > numberOfTickets && creditCard.getAmount() > numberOfTickets * show.getPrice()) {
            show.setMaxTickets(show.getMaxTickets() - numberOfTickets);
            creditCard.setAmount(creditCard.getAmount() - show.getPrice() * numberOfTickets);
            return true;
        }
        return false;
    }

    public boolean returnTicket(Show show, int numberOfTickets) {
        show.setMaxTickets(show.getMaxTickets() + numberOfTickets);
        creditCard.setAmount(creditCard.getAmount() + show.getPrice() * numberOfTickets);
        return true;

    }

}
