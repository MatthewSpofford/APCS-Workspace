
public class Bike extends Vehicles{

	private static final double MAX_BIKE_SPEED = 43.0;
	
	/**
	 * Creates a bike object using the base vehicle data
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 */
	public Bike(String name, String color)
	{
		super(name, color, MAX_BIKE_SPEED);
	}
	
	/**
	 * Returns a string of info about the current vehicle.
	 * @return Outputs the info about the vehicle
	 */
	@Override
	public String info()
	{
		return infoHelper();
	}

	/**
	 * Helps the info method with printing the output
	 * @return Returns the output of the info method
	 */
	private String infoHelper()
	{
		return
				"~Ding Ding Ding!!!\n" +
				"Vehicle: Bike" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n";
	}
}
