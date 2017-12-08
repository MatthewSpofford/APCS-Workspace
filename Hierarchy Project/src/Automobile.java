
/**
 * Used to create a base automobile object from the vehicle class
 * @author Matthew Spofford
 *
 */
public abstract class Automobile extends Vehicles{
	
	int cylinderNum;
	
	/**
	 * Creates the base automobile object, along with the entered cylinder amount
	 * @param name Sets the name data as a string
	 * @param color Sets the color data as a string
	 * @param maxSpeed Sets the maximum speed of the vehicle
	 * @param cylinderNum Sets the amount of cylinders in an automobile
	 */
	public Automobile(String name, String color, double maxSpeed, int cylinderNum)
	{
		super(name, color, maxSpeed);
		this.cylinderNum = cylinderNum;
	}
	
	/**
	 * Sets the number of pistons in an automobile
	 * @param val Sets the piston number to the value given
	 */
	public void setPistonNum(int val)
	{
		if(val < 0)
			return;
		cylinderNum = val;
	}
	/**'
	 * Returns the number of cylinders in an automobile
	 * @return Returns the number of cylinders
	 */
	public int getCylinderNum()
	{
		return cylinderNum;
	}
}
