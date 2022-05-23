package mystageservice;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        HttpResponse<JsonNode> request = Unirest.get("https://catfact.ninja/fact").asJson();
        JSONObject jsonObject = request.getBody().getObject();
        String msg = jsonObject.getString("fact");
        System.out.println(msg);
    }
}
