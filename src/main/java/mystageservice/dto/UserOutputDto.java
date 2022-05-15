package mystageservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import mystageservice.domain.Show;

import java.util.List;

@Data
public class UserOutputDto {

    @JsonProperty
    private String name;
    private String phoneNumber;
    private List<Show> viewedShows;

}
