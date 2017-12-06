
public class ElectricCar extends Automobile{

	double batterySize;
	
	public ElectricCar(String name, int year, String color, double maxSpeed, double batterySize)
	{
		super(name, year, color, maxSpeed, 0);
		this.batterySize = batterySize;
	}
	
	@Override
	/**
	 * Display info about the current vehicle
	 */
	public void info() {
		
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
