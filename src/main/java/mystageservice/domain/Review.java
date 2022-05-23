package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @ManyToOne
    private Critique critique;
    private String review;

    @OneToOne
    private Show show;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "review_key_sequence_generator")
    @SequenceGenerator(name = "review_key_sequence_generator", sequenceName = "review_sequence", allocationSize = 1)
    private Long id;


}
