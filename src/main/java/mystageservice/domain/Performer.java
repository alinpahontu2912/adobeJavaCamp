package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Performer {

    private String name;
    private int age;
    @ManyToMany(mappedBy = "distribution")
    private List<Show> showsList;
    private float rating;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "performer_key_sequence_generator")
    @SequenceGenerator(name = "performer_key_sequence_generator", sequenceName = "performer_sequence", allocationSize = 1)
    private Long id;

    public void calculateRating() {
        float sum = 0;
        for (Show show : showsList) {
            sum += show.getRating();
        }
        rating = sum / showsList.size();
    }


}
