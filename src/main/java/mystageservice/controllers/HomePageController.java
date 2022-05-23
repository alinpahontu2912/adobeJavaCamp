package mystageservice.controllers;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mystageservice.MyStageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomePageController {

    @GetMapping("/")
    public String homePage() {
        HttpResponse<JsonNode> request = Unirest.get(MyStageUtil.catApi).asJson();
        JSONObject jsonObject = request.getBody().getObject();
        String msg = jsonObject.getString(MyStageUtil.catApiKey);
        return "This is the homepage of my app, for now you can enjoy a cool random cat fact:" + '\n' + msg;
    }

}
