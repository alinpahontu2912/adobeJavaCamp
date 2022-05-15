package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CreditCard {

    private String cardNumber;
    private String CVV;
    private Date expiryDate;
    private float amount;

    @OneToOne(mappedBy = "creditCard")
    private User cardOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "card_key_sequence_generator")
    @SequenceGenerator(name = "card_key_sequence_generator", sequenceName = "card_sequence", allocationSize = 1)
    private Long id;

    public boolean isMaestro() {
        return cardNumber.charAt(0) == 5 && cardNumber.charAt(1) == 5;
    }

    public boolean isVisa() {
        return cardNumber.charAt(0) == 4 && cardNumber.charAt(1) == 3;
    }

    public boolean isMasterCard() {
        return cardNumber.charAt(0) == 6 && cardNumber.charAt(1) == 4;
    }

    public boolean isAccepted() {
        return isMaestro() || isVisa() || isMasterCard();
    }


}
