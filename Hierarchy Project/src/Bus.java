
public class Bus extends Automobile implements PublicTransport {

	private double salePrice;
	private int occupantNum;
	
	/**
	 * Creates a bus object using the base automobile data,  along with sale price and occupancy count
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle
	 * @param salePrice Sets the sale price of the vehicle
	 * @param occNum Sets the occupancy count
	 * @param pistonNum Sets the piston count
	 */
	public Bus(String name, String color, double maxSpeed, double salePrice, int occNum, int pistonNum)
	{
		super(name, color, maxSpeed, pistonNum);
		this.salePrice = salePrice;
		occupantNum = occNum;
	}
	
	/**
	 * Display info about the current vehicle
	 */
	@Override
	public void info()
	{
		System.out.println("~Honk Honk!!!\n" + infoHelper());
	}
	
	/**
	 * Helps the info method with printing the output
	 * @return Returns the output of the info method
	 */
	private String infoHelper()
	{
		return
				"Vehicle: Bus" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "\n" +
				"Total Person Cost: " + calculatePrice() + "\n" +
				"Piston Count: " + getPistonNum() + "\n";
	}
	
	/**
	 * Calculates the total cost that every passenger spent on transportation
	 * @return Total cost spent on transport
	 */
	@Override
	public double calculatePrice()
	{
		return salePrice * occupantNum;
	}
}
