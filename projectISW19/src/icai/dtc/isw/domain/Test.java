package icai.dtc.isw.domain;

public class Test{
	/**
	 * 
	 */
	private String id;
	private String name;
	
	public Test() {
		this.setId(new String());
		this.setName(new String());
	}
	
	public Test(String id, String name) {
		this.setName(name);
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
