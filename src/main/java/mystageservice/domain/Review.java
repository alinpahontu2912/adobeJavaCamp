package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Review {

    @OneToOne(cascade = CascadeType.ALL)
    private Critique critique;
    private String review;

    @ManyToOne(cascade = CascadeType.ALL)
    private Show show;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "review_key_sequence_generator")
    @SequenceGenerator(name = "review_key_sequence_generator", sequenceName = "review_sequence", allocationSize = 1)
    private Long id;


}
