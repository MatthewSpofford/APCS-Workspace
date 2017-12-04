
public class Bike extends Vehicles{

	public Bike(String name, String color)
	{
		super(name, 0, color, 43.0);
	}
	
	/**
	 * Display info about the current vehicle
	 */
	@Override
	public void info()
	{
		System.out.println("~Powered by humans!\n"
						 + "Vehicle: Bike\n"
						 + "Model: " + getName() + "\n"
						 + "Color: " + getColor() + "\n"
						 + "Max. Speed: " + getMaxSpeed() + "\n");
	}
}
