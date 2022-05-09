package mystageservice.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PerformerOutputDto {

    @JsonProperty
    private String name;
    private float rating;

}
