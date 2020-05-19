package game.service;

import game.client.GameClient;
import game.model.response.auth.AuthRS;
import game.model.response.play.PlayRS;
import game.model.response.winplay.WinPlayRS;
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
        logResponseAndAssert("Authentication response details:", response);
        return response.as(AuthRS.class);
    }

    public PlayRS getPlay(RequestSpecification spec) {
        Response response = gameClient.get(spec);
        logResponseAndAssert("Play response details:", response);
        return response.as(PlayRS.class);
    }

    public WinPlayRS getWinPlay(RequestSpecification spec) {
        Response response = gameClient.get(spec);
        logResponseAndAssert("WinPlay response details:", response);
        return response.as(WinPlayRS.class);
    }

    private void logResponseAndAssert(String message, Response response) {
        log.info(message);
        response.prettyPrint();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
