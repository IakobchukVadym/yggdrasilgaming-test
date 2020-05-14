package game.model.response.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuxiliaryData {

    @JsonProperty("participation")
    private Object participation;

    @JsonProperty("prizes")
    private Object prizes;

    @JsonProperty("popupMessage")
    private Object popupMessage;

    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("sessionBalance")
    private Object sessionBalance;

    @JsonProperty("ticketId")
    private String ticketId;

    @JsonProperty("funWalletStatus")
    private Object funWalletStatus;

    public Object getParticipation() {
        return participation;
    }

    public Object getPrizes() {
        return prizes;
    }

    public Object getPopupMessage() {
        return popupMessage;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Object getSessionBalance() {
        return sessionBalance;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Object getFunWalletStatus() {
        return funWalletStatus;
    }
}