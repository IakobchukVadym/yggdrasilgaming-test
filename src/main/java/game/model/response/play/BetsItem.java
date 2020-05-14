package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BetsItem{

	@JsonProperty("eventdata")
	private Eventdata eventdata;

	@JsonProperty("betdata")
	private Betdata betdata;

	@JsonProperty("wonamount")
	private String wonamount;

	@JsonProperty("prizes")
	private Object prizes;

	@JsonProperty("step")
	private int step;

	@JsonProperty("betamount")
	private String betamount;

	@JsonProperty("status")
	private String status;

	public Eventdata getEventdata(){
		return eventdata;
	}

	public Betdata getBetdata(){
		return betdata;
	}

	public String getWonamount(){
		return wonamount;
	}

	public Object getPrizes(){
		return prizes;
	}

	public int getStep(){
		return step;
	}

	public String getBetamount(){
		return betamount;
	}

	public String getStatus(){
		return status;
	}
}