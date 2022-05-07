package mystageservice.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShowOutputDto {

    @JsonProperty
    private String name;
    private float rating;
    private int price;
    private int maxTickets;

}
