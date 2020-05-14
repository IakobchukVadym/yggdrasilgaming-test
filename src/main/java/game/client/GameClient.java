package game.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static game.properties.AppProperties.GAME_SERVICE_URL;

@Log4j2
public class GameClient {

    public Response get(RequestSpecification spec) {
        log.info("Sending GET request:");
        spec.log().uri();
        return spec.get(GAME_SERVICE_URL);
    }
}
