package game.model.response.winplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WinPlayRS{

	@JsonProperty("code")
	private int code;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("utcts")
	private long utcts;

	@JsonProperty("fn")
	private String fn;

	public int getCode(){
		return code;
	}

	public Data getData(){
		return data;
	}

	public long getUtcts(){
		return utcts;
	}

	public String getFn(){
		return fn;
	}
}