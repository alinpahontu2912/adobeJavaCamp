package mystageservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PrivilegedUser extends User {

    private List<Discount> discountList;

    @Builder
    public PrivilegedUser(String name, String phoneNumber, String hashPassword, CreditCard creditCard, List<Address> addresses, List<Show> viewedShows, List<Discount> discountList) {
        super(name, phoneNumber, hashPassword, creditCard, addresses, viewedShows);
        this.discountList = discountList;
    }

}
