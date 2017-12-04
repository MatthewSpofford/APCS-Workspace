public abstract class Automobile extends Vehicles{
	
	int pistonNum;
	
	public Automobile(String name, int year, String color, double maxSpeed, int pistonNum)
	{
		super(name, year, color, maxSpeed);
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
