
public class GasCar extends Automobile {

	/**
	 * Creates a gas car object using the base automobile data
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle
	 * @param pistonNum Sets the piston count
	 */
	public GasCar(String name, String color, double maxSpeed, int pistonNum)
	{
		super(name, color, maxSpeed, pistonNum);
	}
	
	/**
	 * Display info about the current vehicle
	 */
	@Override
	public void info()
	{
		System.out.println(infoHelper());
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
				"Maximum Speed: " + getMaxSpeed() + "\n" +
				"Piston Count: " + getPistonNum() + "\n";
	}
}
