
public class Die {

	private int sides;
	private int value;
	
	public Die(int mSides)
	{
		if(mSides <= 0)
			System.exit(-999);;
		
		sides = mSides;
		roll();
	}
	
	public Die()
	{
		sides = 6;
		roll();
	}
	
	public void roll()
	{
		int output;
		
		output = (int) ((Math.random() * sides) + 1);
		
		value = output;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean isDouble(Die die)
	{
		if(this.getValue() == die.getValue())
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		return Integer.toString(value);
	}
}
