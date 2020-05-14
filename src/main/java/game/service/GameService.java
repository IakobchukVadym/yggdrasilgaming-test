package game.service;

import game.client.GameClient;
import game.model.response.auth.AuthRS;
import game.model.response.play.PlayRS;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;

@Log4j2
public class GameService {
    private GameClient gameClient;

    public GameService(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    public AuthRS getAuthentication(RequestSpecification spec) {
        Response response = gameClient.get(spec);
        logResponse(response, "Authentication response details:");
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        return response.as(AuthRS.class);
    }

    public PlayRS getPlay(RequestSpecification spec) {
        Response response = gameClient.get(spec);
        logResponse(response, "Play response details:");
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        return response.as(PlayRS.class);
    }

    private void logResponse(Response response, String message) {
        log.info(message);
        response.prettyPrint();
    }
}
