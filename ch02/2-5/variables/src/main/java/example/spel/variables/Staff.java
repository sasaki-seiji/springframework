package example.spel.variables;

public class Staff {
	private String name;
	private Integer joinedYear;
	
	public Staff(String name, Integer joinedYear) {
		this.name = name;
		this.joinedYear = joinedYear;
	}
	
	public Integer getJoinedYear() { return joinedYear; }
	public void setJoinedYear(Integer value) { joinedYear = value; }
	public String getName() { return name; }
	public void setName(String value) { name = value; }
}
