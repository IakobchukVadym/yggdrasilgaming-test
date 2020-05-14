package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Eventdata {

    @JsonProperty("nextCmds")
    private String nextCmds;

    @JsonProperty("wonCoins")
    private int wonCoins;

    @JsonProperty("rpos")
    private List<Integer> rpos;

    @JsonProperty("wts")
    private List<String> wts;

    @JsonProperty("doubleCount")
    private int doubleCount;

    @JsonProperty("reelSet")
    private String reelSet;

    @JsonProperty("wtw")
    private List<Object> wtw;

    @JsonProperty("reels")
    private List<List<String>> reels;

    @JsonProperty("doubleAmount")
    private String doubleAmount;

    @JsonProperty("accWa")
    private String accWa;

    @JsonProperty("accC")
    private int accC;

    public String getNextCmds() {
        return nextCmds;
    }

    public int getWonCoins() {
        return wonCoins;
    }

    public List<Integer> getRpos() {
        return rpos;
    }

    public List<String> getWts() {
        return wts;
    }

    public int getDoubleCount() {
        return doubleCount;
    }

    public String getReelSet() {
        return reelSet;
    }

    public List<Object> getWtw() {
        return wtw;
    }

    public List<List<String>> getReels() {
        return reels;
    }

    public String getDoubleAmount() {
        return doubleAmount;
    }

    public String getAccWa() {
        return accWa;
    }

    public int getAccC() {
        return accC;
    }
}