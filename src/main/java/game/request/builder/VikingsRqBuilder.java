package game.request.builder;

import static game.properties.AppProperties.ORGANIZATION;
import static game.properties.AppProperties.VIKINGS_GAME_ID;

public class VikingsRqBuilder {
    private VikingsRqBuilder() {
    }

    public static RqBuilder getBaseVikingsRqBuilder() {
        return new RqBuilder().withOrganization(ORGANIZATION)
                .withGameId(VIKINGS_GAME_ID)
                .withLanguage("en")
                .withCurrency("EUR");
    }
}
