public class Plane extends Vehicles implements PublicTransport{

	private double salePrice;
	private int maxCapacity;
	private int occupantNum;
	
	
	public Plane(String name, int year, String color)
	{
		super(name, year, color, 575.0);
	}
	
	@Override
	public void info()
	{
		
	}
	
	/**
	 * Sets the sale price for each person in a vehicle
	 * @param price Sets sale price to value input
	 */
	@Override
	public void setSalePrice(double price)
	{
		salePrice = price;
	}
	/**
	 * Outputs the sale price for each person in a vehicle
	 * @return Outputs sale price
	 */
	@Override
	public double getSalePrice()
	{
		return salePrice;
	}
	
	/**
	 * Sets the maximum capacity of people
	 * @param price Sets the maximum capacity to value input
	 */
	@Override
	public void setMaxCapacity(int maxNum)
	{
		maxCapacity = maxNum;
	}
	/**
	 * Outputs the maximum capacity of people
	 * @return Outputs the maximum capacity
	 */
	@Override
	public int getMaxCapacity()
	{
		return maxCapacity;
	}
	
	/**
	 * Sets the number of occupants in a vehicle
	 * @param price Sets number of occupants to value input
	 */
	@Override
	public void setNumOcc(int num)
	{
		occupantNum = num;
	}
	/**
	 * Outputs the number of occupants in a vehicle
	 * @return Outputs number of occupants
	 */
	@Override
	public int getNumOcc()
	{
		return occupantNum;
	}
}
