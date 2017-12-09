
/**
 * Used to create a plane object from the automobile class, and implements the public transport interface. 
 * A plane objects max speed is also initialized to 550.0mph.
 * @author Matthew Spofford
 *
 */
public class Plane extends Vehicles implements PublicTransport{

	private double salePrice;
	private int occupantNum;
	private static final double MAX_PLANE_SPEED = 550.0;	//Plane max speed is limited to this value
	
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
				"~Wooosh!!!\n" +
				"Vehicle: Plane" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n" +
				"Total Person Cost: $" + String.format("%.2f", calculatePrice()) + "\n";
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
	
	@Override
	public boolean equals(Object obj)
	{
		//If parent equals() is true
		if(super.equals(obj))
		{
			//If classes are equal
			if(this.getClass() == obj.getClass())
			{
				Plane tempObj = (Plane)obj;
				if(this.occupantNum == tempObj.occupantNum &&
				   this.salePrice == tempObj.salePrice)
					return true;
			}
		}
		
		return false;
	}
}
