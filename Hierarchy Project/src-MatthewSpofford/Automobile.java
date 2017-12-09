
/**
 * Used to create an abstract automobile object from the vehicles class, adding feature to store the number of engine cylinders
 * @author Matthew Spofford
 *
 */
public abstract class Automobile extends Vehicles{
	
	int cylinderNum;	//Stores the number of cylinders in an automobile
	
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
	 * Sets the number of cylinder in an automobile.
	 * Returns from the method if value is less than 0.
	 * @param val Sets the cylinder number to the value given
	 */
	public void setCylinderNum(int val)
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
	
	@Override
	public boolean equals(Object obj)
	{
		//If parent equals() is true
		if(super.equals(obj))
		{
			//If classes are equal
			if(this.getClass() == obj.getClass())
			{
				Automobile tempObj = (Automobile)obj;
				if(this.cylinderNum == tempObj.cylinderNum)
					return true;
			}
		}
		
		return false;
	}
}
