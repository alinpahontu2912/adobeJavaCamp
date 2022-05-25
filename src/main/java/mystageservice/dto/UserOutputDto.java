package mystageservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserOutputDto {

    @JsonProperty
    private String name;
    private String phoneNumber;

}
