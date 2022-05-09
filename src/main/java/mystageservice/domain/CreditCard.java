package mystageservice.domain;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class CreditCard {

    private String cardNumber;
    private String CVV;
    private Date expiryDate;

}
