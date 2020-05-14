package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Betdata{

	@JsonProperty("cheat")
	private Object cheat;

	@JsonProperty("initialBalance")
	private String initialBalance;

	@JsonProperty("clientData")
	private Object clientData;

	@JsonProperty("lines")
	private String lines;

	@JsonProperty("nCoins")
	private int nCoins;

	@JsonProperty("coin")
	private String coin;

	public Object getCheat(){
		return cheat;
	}

	public String getInitialBalance(){
		return initialBalance;
	}

	public Object getClientData(){
		return clientData;
	}

	public String getLines(){
		return lines;
	}

	public int getNCoins(){
		return nCoins;
	}

	public String getCoin(){
		return coin;
	}
}