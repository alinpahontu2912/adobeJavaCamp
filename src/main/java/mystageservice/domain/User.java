package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_key_sequence_generator")
    @SequenceGenerator(name = "user_key_sequence_generator", sequenceName = "customer_sequence", allocationSize = 1)
    private Long id;

    private String name;
    private String phoneNumber;
    private String hashPassword;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_to_card", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    private CreditCard creditCard;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_to_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_to_shows", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "show_id"))
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
