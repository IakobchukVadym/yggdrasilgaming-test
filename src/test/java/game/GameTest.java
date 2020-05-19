package game;

import game.model.response.auth.AuthRS;
import game.model.response.play.Betdata;
import game.model.response.play.BetsItem;
import game.model.response.play.Data;
import game.model.response.play.Eventdata;
import game.model.response.play.PlayRS;
import game.model.response.winplay.WinPlayRS;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static game.request.Function.AUTHENTICATE;
import static game.request.Function.PLAY;
import static game.request.builder.VikingsRqBuilder.getBaseVikingsRqBuilder;

public class GameTest implements BaseTest {

    @Test
    void spinUntilWinTest() {
        RequestSpecification authVikingSpec = getBaseVikingsRqBuilder()
                .withFunction(AUTHENTICATE)
                .build();

        AuthRS authRS = gameService.getAuthentication(authVikingSpec);

        String sessid = authRS.getData().getSessid();
        double actualBalance = Double.parseDouble(authRS.getData().getBalance().getCash());
        double bet = 1.25;

        RequestSpecification playSpec = getPlaySpec(sessid, bet);

        SoftAssertions softAssertions = new SoftAssertions();
        PlayRS pendingPlayRS = null;
        boolean win = false;

        while (!win) {
            pendingPlayRS = gameService.getPlay(playSpec);
            win = pendingPlayRS.getData().getWager().getStatus().equals("Pending");
            Double initialBalance = getInitialBalance(pendingPlayRS.getData());

            softAssertions.assertThat(initialBalance)
                    .as("Initial balance should be equal to previous balance minus bet")
                    .isEqualTo(actualBalance);
            softAssertions.assertThat(pendingPlayRS.getFn())
                    .as("Function name should be Play")
                    .isEqualTo(PLAY.getName());

            actualBalance -= bet;
        }

        double winAmountFromPendingRs = getWinAmountFromPendingRs(pendingPlayRS.getData());
        String wagerIdFromPendingRS = pendingPlayRS.getData().getWager().getWagerid();

        RequestSpecification winPlaySpec = getWinPlaySpec(sessid, wagerIdFromPendingRS);
        WinPlayRS winPlayRS = gameService.getWinPlay(winPlaySpec);

        double buyBal = Double.parseDouble(winPlayRS.getData().getBuyBal().getCash());
        double resultBal = Double.parseDouble(winPlayRS.getData().getResultBal().getCash());
        String wagerId = winPlayRS.getData().getWager().getWagerid();
        String status = winPlayRS.getData().getWager().getStatus();

        softAssertions.assertThat(buyBal).isEqualTo(actualBalance);
        softAssertions.assertThat(resultBal).isEqualTo(actualBalance + winAmountFromPendingRs);
        softAssertions.assertThat(wagerId).isEqualTo(wagerIdFromPendingRS);
        softAssertions.assertThat(status).isEqualTo("Finished");
        softAssertions.assertAll();
    }

    private RequestSpecification getPlaySpec(String session, double bet) {
        return getBaseVikingsRqBuilder()
                .withFunction(PLAY)
                .withSession(session)
                .withCoin(0.05)
                .withAmount(bet)
                .build();
    }

    private RequestSpecification getWinPlaySpec(String session, String wagerId) {
        return getBaseVikingsRqBuilder()
                .withFunction(PLAY)
                .withSession(session)
                .withStep(2)
                .withBetId(1)
                .withCmd("C")
                .withWagerId(wagerId)
                .build();
    }

    private double getWinAmountFromPendingRs(@NonNull Data data) {
        return data.getWager().getBets().stream()
                .map(BetsItem::getEventdata)
                .map(Eventdata::getAccWa)
                .map(Double::parseDouble)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("AccWa should always be present in Pending response"));
    }

    private double getInitialBalance(@NonNull Data data) {
        return data.getWager().getBets().stream()
                .map(BetsItem::getBetdata)
                .map(Betdata::getInitialBalance)
                .map(Double::valueOf)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Initial Balance should always be present"));
    }
}
