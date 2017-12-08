
public class Motorbike extends Bike{

	/**
	 * Creates a motorbike object using the base bike data
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle
	 */
	public Motorbike(String name, String color, double maxSpeed) {
		super(name, color);
		setMaxSpeed(maxSpeed);
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
				"~Vroom Vroom!!!\n" +
				"Vehicle: Motorbike\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "\n";
	}
}
