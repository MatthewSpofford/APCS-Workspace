
public class HybridCar extends ElectricCar {
	
	public HybridCar(String name, int year, String color, double maxSpeed, int pistonNum, double batterySize)
	{
		super(name, year, color, maxSpeed, batterySize);
		this.setPistonNum(pistonNum);
	}
	
	@Override
	/**
	 * Display info about the current vehicle
	 */
	public void info() {
		
	}
}
