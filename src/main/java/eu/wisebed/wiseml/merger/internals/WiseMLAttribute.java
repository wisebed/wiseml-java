package eu.wisebed.wiseml.merger.internals;

public class WiseMLAttribute {
	
	private String name;
	private String value;
	
	public WiseMLAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

}
