
public abstract class Automobile extends Vehicles{
	
	public Automobile(String color, double maxSpeed)
	{
		super(color, maxSpeed);
	}
	
	@Override
	public void move()
	{
		System.out.println();
	}
}
