package tv.tweek.sender;

public enum Queue {

	TWEEK("tweekQueue"),
	DEFAULT("default");
	
	private String name;

	private Queue(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
}
