package mystageservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowApiOutputDto {

    @JsonProperty
    String name;
    String plot;
    String genre;
    String imdbRating;
    boolean foundInDatabase;

}
