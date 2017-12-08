
/**
 * 
 * @author Matthew Spofford
 *
 */
public abstract class Automobile extends Vehicles{
	
	int pistonNum;
	
	/**
	 * Creates the base automobile object, along with the entered piston amount
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle
	 * @param pistonNum
	 */
	public Automobile(String name, String color, double maxSpeed, int pistonNum)
	{
		super(name, color, maxSpeed);
		this.pistonNum = pistonNum;
	}
	
	/**
	 * Sets the number of pistons in an automobile
	 * @param val Sets the piston number to the value given
	 */
	public void setPistonNum(int val)
	{
		if(val < 0)
			return;
		pistonNum = val;
	}
	/**'
	 * Returns the number of pistons in an automobile
	 * @return Returns the number of pistons
	 */
	public int getPistonNum()
	{
		return pistonNum;
	}
}
