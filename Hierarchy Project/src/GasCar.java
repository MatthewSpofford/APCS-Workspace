
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
	
	@Override
	/**
	 * Display info about the current vehicle
	 */
	public void info() {

	}
}
