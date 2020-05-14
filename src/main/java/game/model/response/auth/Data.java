package game.model.response.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("auxiliaryData")
    private AuxiliaryData auxiliaryData;

    @JsonProperty("country")
    private Object country;

    @JsonProperty("balance")
    private Balance balance;

    @JsonProperty("org")
    private String org;

    @JsonProperty("nativeSessid")
    private String nativeSessid;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("language")
    private String language;

    @JsonProperty("nativeId")
    private String nativeId;

    @JsonProperty("userid")
    private String userid;

    @JsonProperty("userProps")
    private UserProps userProps;

    @JsonProperty("sessid")
    private String sessid;

    public AuxiliaryData getAuxiliaryData() {
        return auxiliaryData;
    }

    public Object getCountry() {
        return country;
    }

    public Balance getBalance() {
        return balance;
    }

    public String getOrg() {
        return org;
    }

    public String getNativeSessid() {
        return nativeSessid;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLanguage() {
        return language;
    }

    public String getNativeId() {
        return nativeId;
    }

    public String getUserid() {
        return userid;
    }

    public UserProps getUserProps() {
        return userProps;
    }

    public String getSessid() {
        return sessid;
    }
}