package game.model.response.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProps {

    @JsonProperty("game")
    private Game game;

    @JsonProperty("id")
    private Id id;

    public Game getGame() {
        return game;
    }

    public Id getId() {
        return id;
    }
}