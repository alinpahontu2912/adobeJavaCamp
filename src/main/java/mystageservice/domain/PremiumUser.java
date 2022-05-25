package mystageservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("2")
public class PremiumUser extends User {

    private float discount;

    @Builder
    public PremiumUser(Long id, String name, String phoneNumber, String hashPassword, CreditCard creditCard, List<Address> addresses, List<Show> viewedShows, float discount) {
        super(id, name, phoneNumber, hashPassword, creditCard, addresses, viewedShows);
        this.discount = discount;
    }

    @Override
    public boolean buyTicket(Show show, int numberOfTickets) {
        if (getCreditCard().isCorrect() && show.getMaxTickets() > numberOfTickets && getCreditCard().isAccepted(numberOfTickets * show.getPrice() * discount)) {
            show.setMaxTickets(show.getMaxTickets() - numberOfTickets);
            getCreditCard().setAmount(getCreditCard().getAmount() - show.getPrice() * numberOfTickets * discount);
            return true;
        }
        return false;
    }
}
