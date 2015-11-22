package tv.tweek.model;

import java.io.Serializable;
import java.util.Date;

public class Test implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Long timestamp;
	
	public Test() {
		this.name = "Test";
		this.timestamp = new Date().getTime();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
