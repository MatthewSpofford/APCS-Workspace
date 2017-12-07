
public abstract class Vehicles implements Comparable<Vehicles>{
	
	private String name;
	private int year;
	private String color;
	private double maxSpeed;
	private static int vehiclesMade = 0;
	
	/**
	 * Constructs a vehicle
	 * @param name Stores the given brand name of a vehicle
	 * @param color Represents the color of the vehicle
	 * @param maxSpeed Represents the maximum speed of the vehicle
	 */
	public Vehicles(String name, int year, String color, double maxSpeed)
	{
		this.name = name;
		this.year = year;
		this.color = color;
		this.maxSpeed = maxSpeed;
		vehiclesMade += 1;
	}
	
	/**
	 * Display info about the current vehicle
	 */
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
	 * Outputs the number of vehicles created
	 * @return Outputs amount made
	 */
	public static int getNumVehiclesMade()
	{
		return vehiclesMade;
	}
	
	/**
	 * Sets the maximum speed for a vehicle
	 * @param val Sets the maximum speed to the value given
	 */
	public void setMaxSpeed(double val)
	{
		if(val < 0)
			return;
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
	
	@Override
	public boolean equals(Object obj)
	{		
		if(obj.getClass() != this.getClass())
			return false;
		
		Vehicles temp = (Vehicles)obj;
		if(temp.getColor().equals(getColor()) &&
		   temp.getMaxSpeed() == getMaxSpeed() &&
		   temp.getName().equals(getName()) &&
		   temp.getYear() == getYear())
			return true;
		else
			return false;
	}
	
	@Override
	/**
	 * Method compares brand name, then year, then color, and then maximum speed
	 */
	public int compareTo(Vehicles obj)
	{
		int compare = obj.name.compareTo(this.name);
		if(compare == 0)
		{
			Integer objYear = new Integer(obj.year);
			Integer tempYear = new Integer(this.year);
			
			compare = objYear.compareTo(tempYear);
			if(compare == 0)
			{
				compare = obj.color.compareTo(this.color);
				if(compare == 0)
				{
					Double objMaxSp = new Double(obj.maxSpeed);
					Double tempMaxSp = new Double(this.maxSpeed);
					
					compare = objMaxSp.compareTo(tempMaxSp);
				}
			}
		}
		
		return compare;
	}
}
