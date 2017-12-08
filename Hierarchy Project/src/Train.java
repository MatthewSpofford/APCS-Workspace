public class Train extends Vehicles implements PublicTransport{

	private double salePrice;
	private int occupantNum;
	
	/**
	 * Creates a train object using the base vehicle data, along with sale price and occupancy count
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle
	 * @param salePrice Sets the sale price of the vehicle
	 * @param occNum Sets the occupancy count
	 */
	public Train(String name, String color,  double maxSpeed, double salePrice, int occNum)
	{
		super(name, color, maxSpeed);
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
				"~Choo Choo!!!\n" + 
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
				Train tempObj = (Train)obj;
				if(this.occupantNum == tempObj.occupantNum &&
				   this.salePrice == tempObj.salePrice)
					return true;
			}
		}
		
		return false;
	}
}
