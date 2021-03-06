
/**
 * Used to create a hybrid car object from the electric car, that uses both battery size and the automobile cylinder amount
 * @author Matthew Spofford
 */
public class HybridCar extends ElectricCar {
	
	/**
	 * Creates a hybrid car object using the base electric car data
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle (mph)
	 * @param cylinderNum Sets the number of cylinders of the automobile
	 * @param batterySize Sets the size of the battery (kWh)
	 */
	public HybridCar(String name, String color, double maxSpeed, int cylinderNum, double batterySize)
	{
		super(name, color, maxSpeed, batterySize);
		this.setCylinderNum(cylinderNum);
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
				"Vehicle: Hybrid Car\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n" +
				"Battery Size: " + getBatterySize() + "kWh\n" +
				"Cylinder Count: " + getCylinderNum() + "\n";
	}

}
