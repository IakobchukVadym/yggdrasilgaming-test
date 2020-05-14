package game.request;

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

    public RqBuilder withGameId(int gameId) {
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

    public RqBuilder withCoin(Double coin) {
        spec.queryParam("coin", coin);
        return this;
    }

    public RqBuilder withAmount(double amount) {
        spec.queryParam("amount", amount);
        return this;
    }

    public RequestSpecification build() {
        return spec;
    }
}
