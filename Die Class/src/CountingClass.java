
public class CountingClass {
	
	private Die die1 = new Die(6);
	private Die die2 = new Die(6);
	
	public int countUntlDouble()
	{
		int counter = 0;
		boolean done = false;
		
		while(!done)
		{
			die1.roll();
			die2.roll();
			
			System.out.println(die1 + "   " + die2);
			
			if(die1.getValue() == die2.getValue())
				done = true;
			counter++;
		}
		
		return counter;
	}
}
