package game.model.response.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    @JsonProperty("rate")
    private String rate;

    public String getRate() {
        return rate;
    }
}