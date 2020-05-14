package game;

import game.model.response.auth.AuthRS;
import game.model.response.play.Betdata;
import game.model.response.play.BetsItem;
import game.model.response.play.Data;
import game.model.response.play.Eventdata;
import game.model.response.play.PlayRS;
import game.request.RqBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static game.request.Function.AUTHENTICATE;
import static game.request.Function.PLAY;

public class GameTest implements BaseTest {

    @Test
    void spinUntilWinTest() {
        RequestSpecification authSpec = new RqBuilder()
                .withFunction(AUTHENTICATE)
                .withOrganization("Demo")
                .build();

        AuthRS authRS = gameService.getAuthentication(authSpec);

        String session = authRS.getData().getSessid();
        double bet = 1.25;
        double actualBalance = Double.parseDouble(authRS.getData().getBalance().getCash());
        RequestSpecification playSpec = getPlaySpec(session, bet);

        SoftAssertions softAssertions = new SoftAssertions();
        boolean win = false;
        while (!win) {
            PlayRS playRS = gameService.getPlay(playSpec);
            win = isWinner(playRS.getData());
            Double initialBalance = getInitialBalance(playRS.getData());

            softAssertions.assertThat(initialBalance)
                    .as("Initial balance should be equal to previous balance minus bet")
                    .isEqualTo(actualBalance);
            softAssertions.assertThat(playRS.getFn())
                    .as("Function name should be Play")
                    .isEqualTo(PLAY.getName());

            actualBalance -= bet;
        }
        softAssertions.assertAll();
    }

    private RequestSpecification getPlaySpec(String session, double bet) {
        return new RqBuilder()
                .withFunction(PLAY)
                .withGameId(7316)
                .withLanguage("en")
                .withCurrency("EUR")
                .withSession(session)
                .withCoin(0.05)
                .withAmount(bet)
                .build();
    }

    private boolean isWinner(@NonNull Data data) {
        return data.getWager().getBets().stream()
                .map(BetsItem::getEventdata)
                .map(Eventdata::getAccWa)
                .map(Double::parseDouble)
                .anyMatch(result -> result > 0);
    }

    private Double getInitialBalance(@NonNull Data data) {
        return data.getWager().getBets().stream()
                .map(BetsItem::getBetdata)
                .map(Betdata::getInitialBalance)
                .map(Double::valueOf)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Initial Balance should always be present"));
    }
}
