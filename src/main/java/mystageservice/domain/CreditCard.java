package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class CreditCard {

    private String cardNumber;
    private String CVV;
    private Date expiryDate;
    private float amount;

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
