
/**
 * Used to create a bike object from the vehicles class, initializing the max speed to 32.5mph
 * @author Matthew Spofford
 *
 */
public class Bike extends Vehicles{

	private static final double MAX_BIKE_SPEED = 32.5; //Max speed is limited because of humans powering bikes 
	
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
