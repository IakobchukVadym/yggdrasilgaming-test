package game.model.response.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {

    @JsonProperty("nativeid")
    private String nativeid;

    public String getNativeid() {
        return nativeid;
    }
}