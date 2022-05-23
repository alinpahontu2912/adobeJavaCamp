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
public class PrivilegedUser extends User {

    private float discount;

    @Builder
    public PrivilegedUser(Long id, String name, String phoneNumber, String hashPassword, CreditCard creditCard, List<Address> addresses, List<Show> viewedShows, float discount) {
        super(id, name, phoneNumber, hashPassword, creditCard, addresses, viewedShows);
        this.discount = discount;
    }

}
