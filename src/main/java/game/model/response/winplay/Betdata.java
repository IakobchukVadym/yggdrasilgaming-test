package game.model.response.winplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Betdata{

	@JsonProperty("cheat")
	private Object cheat;

	@JsonProperty("restoredAccumulatedWonCoin")
	private int restoredAccumulatedWonCoin;

	@JsonProperty("doubleA")
	private String doubleA;

	@JsonProperty("variant")
	private Object variant;

	@JsonProperty("doubleN")
	private int doubleN;

	@JsonProperty("cmd")
	private String cmd;

	@JsonProperty("lines")
	private String lines;

	@JsonProperty("nCoins")
	private int nCoins;

	@JsonProperty("coin")
	private String coin;

	public Object getCheat(){
		return cheat;
	}

	public int getRestoredAccumulatedWonCoin(){
		return restoredAccumulatedWonCoin;
	}

	public String getDoubleA(){
		return doubleA;
	}

	public Object getVariant(){
		return variant;
	}

	public int getDoubleN(){
		return doubleN;
	}

	public String getCmd(){
		return cmd;
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