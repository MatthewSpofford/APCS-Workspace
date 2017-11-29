
public class Train extends Vehicles implements PublicTransport{

	private double salePrice;
	private int maxCapacity;
	private int occupantNum;
	
	
	public Train(String color, double maxSpeed)
	{
		super(color, maxSpeed);
	}
	
	@Override
	public void move()
	{
		
	}
	
	/**
	 * Sets the sale price for each person in a vehicle
	 * @param price Sets sale price to value input
	 */
	public void setSalePrice(double price)
	{
		salePrice = price;
	}
	/**
	 * Outputs the sale price for each person in a vehicle
	 * @return Outputs sale price
	 */
	public double getSalePrice()
	{
		return salePrice;
	}
	
	/**
	 * Sets the maximum capacity of people
	 * @param price Sets the maximum capacity to value input
	 */
	public void setMaxCapacity(int maxNum)
	{
		maxCapacity = maxNum;
	}
	/**
	 * Outputs the maximum capacity of people
	 * @return Outputs the maximum capacity
	 */
	public int getMaxCapacity()
	{
		return maxCapacity;
	}
	
	/**
	 * Sets the number of occupants in a vehicle
	 * @param price Sets number of occupants to value input
	 */
	public void setNumOcc(int num)
	{
		occupantNum = num;
	}
	/**
	 * Outputs the number of occupants in a vehicle
	 * @return Outputs number of occupants
	 */
	public int getNumOcc()
	{
		return occupantNum;
	}

}
