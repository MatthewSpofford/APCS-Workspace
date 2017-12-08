public class Plane extends Vehicles implements PublicTransport{

	private double salePrice;
	private int occupantNum;
	private static final double MAX_PLANE_SPEED = 525.75;
	
	/**
	 * Creates a plane object using the base vehicle data, along with sale price and occupancy count
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param salePrice Sets the sale price of the vehicle
	 * @param occNum Sets the occupancy count
	 */
	public Plane(String name, String color, double salePrice, int occNum)
	{
		super(name, color, MAX_PLANE_SPEED);
		this.salePrice = salePrice;
		occupantNum = occNum;
	}
	
	/**
	 * Display info about the current vehicle
	 */
	@Override
	public void info()
	{
		System.out.println("~Wooosh!!!\n" + infoHelper());
	}
	
	/**
	 * Helps the info method with printing the output
	 * @return Returns the output of the info method
	 */
	private String infoHelper()
	{
		return
				"Vehicle: Plane" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "\n" +
				"Total Person Cost: " + calculatePrice() + "\n";
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
