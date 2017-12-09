
/**
 * Used to create an electric car object from the automobile class, adding a battery size feature and limiting cylinder count to 0
 * @author Matthew Spofford
 *
 */
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
				"Vehicle: Electric Car" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n" +
				"Battery Size: " + getBatterySize() + "kWh\n";
	}


	/**
	 * Sets the battery size of a vehicle.
	 * Returns fromt he method if size is less than 0
	 * @param size Sets the battery size of a vehicle (kWh)
	 */
	public void setBatterySize(double size)
	{
		if(size < 0)
			return;
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
	
	@Override
	public boolean equals(Object obj)
	{
		//If parent equals() is true
		if(super.equals(obj))
		{
			//If classes are equal
			if(this.getClass() == obj.getClass())
			{
				ElectricCar tempObj = (ElectricCar)obj;
				if(this.batterySize == tempObj.batterySize)
					return true;
			}
		}
		
		return false;
	}
}
