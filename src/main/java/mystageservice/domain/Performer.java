package mystageservice.domain;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Performer {

    private String name;
    private int age;
    private List<Show> showsList;
    private float rating;

    public void calculateRating() {
        float sum = 0;
        for (Show show : showsList) {
            sum += show.getRating();
        }
        rating = sum / showsList.size();
    }

}
