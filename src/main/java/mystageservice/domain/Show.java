package mystageservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "show_type", discriminatorType = DiscriminatorType.INTEGER)
public class Show {

    private String name;
    private Date date;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "shows_to_performers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "performer_id")
    )
    private List<Performer> distribution;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> critiquesReviews;
    private float rating;
    private int numberOfRatings;
    private int duration;
    private float price;
    private int maxTickets;

    @ManyToMany(mappedBy = "viewedShows")
    private List<User> viewedBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "show_key_sequence_generator")
    @SequenceGenerator(name = "show_key_sequence_generator", sequenceName = "show_sequence", allocationSize = 1)
    private Long id;

    public float performersTotalRating() {
        float sum = 0;
        for (Performer performer : distribution) {
            sum += performer.getRating();
        }
        sum /= distribution.size();
        return sum;
    }

}
