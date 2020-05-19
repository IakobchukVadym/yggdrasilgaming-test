package game.request.builder;

import game.request.Function;
import io.restassured.specification.RequestSpecification;

import static game.properties.AppProperties.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class RqBuilder {
    private RequestSpecification spec = given()
            .accept(JSON)
            .baseUri(BASE_URL);

    public RqBuilder withFunction(Function function) {
        spec.queryParam("fn", function.getName());
        return this;
    }

    public RqBuilder withOrganization(String organization) {
        spec.queryParam("org", organization);
        return this;
    }

    public RqBuilder withGameId(String gameId) {
        spec.queryParam("gameid", gameId);
        return this;
    }

    public RqBuilder withLanguage(String language) {
        spec.queryParam("lang", language);
        return this;
    }

    public RqBuilder withCurrency(String currency) {
        spec.queryParam("currency", currency);
        return this;
    }

    public RqBuilder withSession(String session) {
        spec.queryParam("sessid", session);
        return this;
    }

    public RqBuilder withCoin(double coin) {
        spec.queryParam("coin", coin);
        return this;
    }

    public RqBuilder withAmount(double amount) {
        spec.queryParam("amount", amount);
        return this;
    }

    public RqBuilder withWagerId(String wagerId) {
        spec.queryParam("wagerid", wagerId);
        return this;
    }

    public RqBuilder withStep(int step) {
        spec.queryParam("step", step);
        return this;
    }

    public RqBuilder withBetId(int betId) {
        spec.queryParam("betid", betId);
        return this;
    }

    public RqBuilder withCmd(String cmd) {
        spec.queryParam("cmd", cmd);
        return this;
    }

    public RequestSpecification build() {
        return spec;
    }
}
