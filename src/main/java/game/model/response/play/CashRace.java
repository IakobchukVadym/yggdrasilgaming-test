package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashRace{

	@JsonProperty("resource")
	private Object resource;

	@JsonProperty("hasWon")
	private boolean hasWon;

	@JsonProperty("currency")
	private Object currency;

	@JsonProperty("prize")
	private Object prize;

	@JsonProperty("initialPrize")
	private Object initialPrize;

	public Object getResource(){
		return resource;
	}

	public boolean isHasWon(){
		return hasWon;
	}

	public Object getCurrency(){
		return currency;
	}

	public Object getPrize(){
		return prize;
	}

	public Object getInitialPrize(){
		return initialPrize;
	}
}