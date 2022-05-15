package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "address_key_sequence_generator")
    @SequenceGenerator(name = "address_key_sequence_generator", sequenceName = "address_sequence", allocationSize = 1)
    private Long id;
    private String address;
    @ManyToMany(mappedBy = "addresses")
    private List<User> userList;

}
