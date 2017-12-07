
public class Bus extends Automobile implements PublicTransport {

	private final double salePrice = 1.22;
	private int maxCapacity;
	private int occupantNum;
	
	public Bus(String name, int year, String color, double maxSpeed, int pistonNum)
	{
		super(name, year, color, maxSpeed, pistonNum);
	}
	
	@Override
	/**
	 * Display info about the current vehicle
	 */
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
