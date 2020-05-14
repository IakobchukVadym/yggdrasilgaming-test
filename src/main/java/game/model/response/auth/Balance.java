package game.model.response.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Balance {

    @JsonProperty("cash")
    private String cash;

    public String getCash() {
        return cash;
    }
}