
public abstract class Vehicles {
	
	private String name;
	private int year;
	private String color;
	private double maxSpeed;
	
	public Vehicles(String name, int year, String color, double maxSpeed)
	{
		this.name = name;
		this.year = year;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	public abstract void info();
	
	/**
	 * Sets the cost color of a vehicle
	 * @param val Sets the color to the value given
	 */
	public void setColor(String val)
	{
		color = val;
	}
	/**
	 * Outputs the color for a vehicle
	 * @return Outputs the color
	 */
	public String getColor()
	{
		return color;
	}
	
	/**
	 * Sets the maximum speed for a vehicle
	 * @param val Sets the maximum speed to the value given
	 */
	public void setMaxSpeed(double val)
	{
		maxSpeed = val;
	}
	/**
	 * Outputs the maximum speed for a vehicle
	 * @return Outputs the maximum speed
	 */
	public double getMaxSpeed()
	{
		return maxSpeed;
	}
	
	/**
	 * Sets the year for a vehicle
	 * @param val Sets the year to the value given
	 */
	public void setYear(int val)
	{
		year = val;
	}
	/**
	 * Outputs the year for a vehicle
	 * @return Outputs the year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Sets the name for a vehicle
	 * @param val Sets the name to the value given
	 */
	public void setName(String val)
	{
		name = val;
	}
	/**
	 * Outputs the name for a vehicle
	 * @return Outputs the name
	 */
	public String getName()
	{
		return name;
	}
}
