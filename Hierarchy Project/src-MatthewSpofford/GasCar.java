
/**
 * Used to create a gas car object from the automobile class
 * @author Matthew Spofford
 *
 */
public class GasCar extends Automobile {

	/**
	 * Creates a gas car object using the base automobile data
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle (mph)
	 * @param cylinderNum Sets the cylinder count
	 */
	public GasCar(String name, String color, double maxSpeed, int cylinderNum)
	{
		super(name, color, maxSpeed, cylinderNum);
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
				"~Beep Beep!!!\n" + 
				"Vehicle: Gas Car" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n" +
				"Cylinder Count: " + getCylinderNum() + "\n";
	}
}
