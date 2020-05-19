package game.model.response.winplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrizesItem{

	@JsonProperty("gameId")
	private int gameId;

	@JsonProperty("descr")
	private String descr;

	@JsonProperty("wonamount")
	private String wonamount;

	@JsonProperty("type")
	private String type;

	@JsonProperty("woncurrency")
	private String woncurrency;

	@JsonProperty("wonAspect")
	private String wonAspect;

	@JsonProperty("prizeid")
	private String prizeid;

	@JsonProperty("netamount")
	private String netamount;

	@JsonProperty("prizedata")
	private Object prizedata;

	public int getGameId(){
		return gameId;
	}

	public String getDescr(){
		return descr;
	}

	public String getWonamount(){
		return wonamount;
	}

	public String getType(){
		return type;
	}

	public String getWoncurrency(){
		return woncurrency;
	}

	public String getWonAspect(){
		return wonAspect;
	}

	public String getPrizeid(){
		return prizeid;
	}

	public String getNetamount(){
		return netamount;
	}

	public Object getPrizedata(){
		return prizedata;
	}
}