
public class HybridCar extends ElectricCar {
	
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
				"Battery Size: " + getBatterySize() + "\n" +
				"Piston Count: " + getPistonNum() + "\n";
	}

}
