
public abstract class Vehicles implements Comparable<Vehicles>{
	
	private String name;
	private String color;
	private double maxSpeed;
	private static int vehiclesMade = 0;
	
	/**
	 * Constructs a vehicle
	 * @param name Stores the given brand name of a vehicle
	 * @param color Represents the color of the vehicle
	 * @param maxSpeed Represents the maximum speed of the vehicle
	 */
	public Vehicles(String name, String color, double maxSpeed)
	{
		this.name = name;
		this.color = color;
		this.maxSpeed = maxSpeed;
		vehiclesMade += 1;
	}
	
	/**
	 * Display info about the current vehicle.
	 * First displays the sound it creates, 
	 * then the type of vehicle, and then any other needed data
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
		   temp.getName().equals(getName()))
			return true;
		else
			return false;
	}
	
	@Override
	/**
	 * Method compares brand name, then color, and then maximum speed
	 */
	public int compareTo(Vehicles obj)
	{
		if(this.equals(obj))
			return 0;
		
		int compare = obj.name.compareTo(this.name);
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
		
		return compare;
	}
}
