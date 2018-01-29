
public abstract class Vehicle {
	
	protected String name = "";
	
	public Vehicle(String name) {
		this.name = name;
	}
	
	public abstract void move();
}
