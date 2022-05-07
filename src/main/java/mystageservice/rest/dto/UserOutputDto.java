package mystageservice.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

@Data
public class UserOutputDto {

    @JsonProperty
    private String name;

}
