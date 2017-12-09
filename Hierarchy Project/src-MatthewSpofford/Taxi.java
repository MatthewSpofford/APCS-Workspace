
/**
 * Used to create a taxi object from the automobile class, implementing the public transport interface.
 * The taxi object color is always initialized as "Yellow"
 * @author Matthew Spofford
 *
 */
public class Taxi extends Automobile implements PublicTransport {

	private double salePrice;
	private int occupantNum;
	private static final String TAXI_COLOR = "Yellow";
	
	/**
	 * Creates a bus object using the base automobile data,  along with sale price and occupancy count.
	 * The taxi color is set to yellow
	 * @param name Sets the name data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle (mph)
	 * @param salePrice Sets the sale price of the vehicle
	 * @param occNum Sets the occupancy count
	 * @param cylinderNum Sets the cylinder count
	 */
	public Taxi(String name, double maxSpeed, double salePrice, int occNum, int cylinderNum)
	{
		super(name, TAXI_COLOR, maxSpeed, cylinderNum);
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
				"~Beep Beep!!!\n" + 
				"Vehicle: Taxi" + "\n" + 
				"Model: " + getName() + "\n" + 
				"Color: " + getColor() + "\n" +
				"Maximum Speed: " + getMaxSpeed() + "mph\n" +
				"Total Person Cost: $" + String.format("%.2f", calculatePrice()) + "\n" + 
				"Cylinder Count: " + getCylinderNum() + "\n";

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
				Taxi tempObj = (Taxi)obj;
				if(this.occupantNum == tempObj.occupantNum &&
				   this.salePrice == tempObj.salePrice)
					return true;
			}
		}
		
		return false;
	}
}
