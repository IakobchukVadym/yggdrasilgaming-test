package game.model.response.play;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayRS {

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