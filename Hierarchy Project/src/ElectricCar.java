
public class ElectricCar extends Automobile{

	private double batterySize;
	
	/**
	 * Creates a gas car object using the base automobile data, along with battery size
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle (mph)
	 * @param batterySize Sets the size of the battery of the vehicle (kWh)
	 */
	public ElectricCar(String name, String color, double maxSpeed, double batterySize)
	{
		super(name, color, maxSpeed, 0);
		this.batterySize = batterySize;
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
				"Vehicle: Hybrid Car" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "\n" +
				"Battery Size: " + getBatterySize() + "\n";
	}


	/**
	 * Sets the battery size of a vehicle
	 * @param size Sets the battery size of a vehicle (kWh)
	 */
	public void setBatterySize(double size)
	{
		batterySize = size;
	}
	/**
	 * Gets the battery size of a vehicle
	 * @return Outputs the battery size of a vehicle (kWh)
	 */
	public double getBatterySize()
	{
		return batterySize;
	}
}
