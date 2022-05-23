package mystageservice.services.movieApi;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import mystageservice.MyStageUtil;
import mystageservice.dto.ShowApiOutputDto;

public class ShowApiService {

    public static ShowApiOutputDto getInfo(String showTitle) throws Exception {
        String requestURL = MyStageUtil.movieApi +
                showTitle;
        HttpResponse<JsonNode> request = Unirest.get(requestURL).asJson();
        JSONObject jsonObject = request.getBody().getObject();
        if (jsonObject == null) throw new Exception("No such show found, sorry!");
        String plot = jsonObject.getString("Plot");
        String genre = jsonObject.getString("Genre");
        String imdbRating = jsonObject.getString("imdbRating");
        return ShowApiOutputDto.builder().plot(plot)
                .genre(genre).imdbRating(imdbRating)
                .name(showTitle).foundInDatabase(false).build();
    }

}
