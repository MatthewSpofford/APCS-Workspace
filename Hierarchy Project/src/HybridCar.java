
/**
 * Is used to store information and create a hydrid car object
 * @author Matthew Spofford
 */
public class HybridCar extends ElectricCar {
	
	/**
	 * Creates a hybrid car object using the base electric car data
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle (mph)
	 * @param pistonNum Sets the number of pistons of the automobile
	 * @param batterySize Sets the size of the battery (kWh)
	 */
	public HybridCar(String name, String color, double maxSpeed, int pistonNum, double batterySize)
	{
		super(name, color, maxSpeed, batterySize);
		this.setPistonNum(pistonNum);
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
				"Vehicle: Hybrid Car\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n" +
				"Battery Size: " + getBatterySize() + "kWh\n" +
				"Piston Count: " + getCylinderNum() + "\n";
	}

}
