
public abstract class Automobile extends Vehicles{
	
	public Automobile(String name, int year, String color, double maxSpeed)
	{
		super(name, year, color, maxSpeed);
	}
	
	@Override
	public void info()
	{
		System.out.println("");
	}
}
