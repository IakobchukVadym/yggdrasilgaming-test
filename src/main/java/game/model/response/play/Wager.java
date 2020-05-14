package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Wager{

	@JsonProperty("wagerid")
	private String wagerid;

	@JsonProperty("prepaid")
	private boolean prepaid;

	@JsonProperty("bets")
	private List<BetsItem> bets;

	@JsonProperty("timestamp")
	private long timestamp;

	@JsonProperty("status")
	private String status;

	public String getWagerid(){
		return wagerid;
	}

	public boolean isPrepaid(){
		return prepaid;
	}

	public List<BetsItem> getBets(){
		return bets;
	}

	public long getTimestamp(){
		return timestamp;
	}

	public String getStatus(){
		return status;
	}
}