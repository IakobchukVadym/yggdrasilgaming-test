package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("wager")
	private Wager wager;

	@JsonProperty("buyBal")
	private BuyBal buyBal;

	@JsonProperty("obj")
	private Object obj;

	@JsonProperty("cashRace")
	private CashRace cashRace;

	@JsonProperty("resultBal")
	private ResultBal resultBal;

	@JsonProperty("missionState")
	private Object missionState;

	public Wager getWager(){
		return wager;
	}

	public BuyBal getBuyBal(){
		return buyBal;
	}

	public Object getObj(){
		return obj;
	}

	public CashRace getCashRace(){
		return cashRace;
	}

	public ResultBal getResultBal(){
		return resultBal;
	}

	public Object getMissionState(){
		return missionState;
	}
}