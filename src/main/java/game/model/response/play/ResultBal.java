package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultBal{

	@JsonProperty("cash")
	private String cash;

	public String getCash(){
		return cash;
	}
}