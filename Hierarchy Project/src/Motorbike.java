
public class Motorbike extends Bike{

	/**
	 * 
	 * @param name
	 * @param year
	 * @param color
	 * @param maxSpeed
	 */
	public Motorbike(String name, int year, String color, double maxSpeed) {
		super(name, color);
		setMaxSpeed(maxSpeed);
	}
	
	/**
	 * Display info about the current vehicle
	 */
	@Override
	public void info()
	{
		System.out.println("~Beep Beep!!!\n" + infoHelper());
	}
	
	/**
	 * Helps the info method with printing the output
	 * @return Returns the output of the info method
	 */
	private String infoHelper()
	{
		return
				"Vehicle: Hybrid Car" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "\n" +
				"
	}
}
