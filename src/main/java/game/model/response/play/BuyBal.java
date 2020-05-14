package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyBal{

	@JsonProperty("cash")
	private String cash;

	public String getCash(){
		return cash;
	}
}