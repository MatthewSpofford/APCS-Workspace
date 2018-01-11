
public class MagicSquare {

	private int[][] magicSquare;
	
	public MagicSquare()
	{
		magicSquare = new int[3][3];
		generateSquare();
	}
	
	public MagicSquare(int sideLength)
	{
		magicSquare = new int[sideLength][sideLength];
		generateSquare();
	}
	
	public boolean validSquare()
	{
		int sumValue = 0;
		int currentValue = 0;
		
		for(int i = 0; i < 1; i++) 
		{
			for(int j = 0; j < magicSquare[i].length; j++) 
			{
				sumValue += magicSquare[i][j];
			}
		}
		
		for(int i = 0; i < magicSquare.length; i++)
		{
			currentValue = 0;
			for(int j = 0; j < magicSquare[i].length; j++)
			{
				currentValue += magicSquare[i][j];
			}
			
			if(currentValue != sumValue)
				return false;
		}
		
		int j = 0;
		currentValue = 0;
		for(int i = 0; i < magicSquare.length && j < magicSquare[0].length; i++)
		{
			currentValue += magicSquare[i][j++];
		}
		if(currentValue != sumValue)
			return false;
		
		j = magicSquare[0].length - 1;
		currentValue = 0;
		for(int i = 0; i < magicSquare.length && j >= 0; i++)
		{
			currentValue += magicSquare[i][j--];
		}
		if(currentValue != sumValue)
			return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		String output = "";
		
		for(int i = 0; i < magicSquare.length; i++)
		{
			for(int j = 0; j < magicSquare[i].length; j++)
			{
				output += magicSquare[i][j] + "	";
			}
			output += "\n";
		}
		
		return output;
	}
	
	private void generateSquare()
	{
		if(magicSquare.length % 2 != 0)
		{
			generateOddSquare();
		}
		else
		{
			generateEvenSquare();
		}
	}
	
	private void generateOddSquare()
	{
		int currentVal = 0;
		int i = 0;
		int j = (magicSquare[0].length / 2);;
		
		do
		{
			magicSquare[i--][j++] = ++currentVal;
			
			if(i < 0)
				i = magicSquare.length - 1;
			if(j >= magicSquare[0].length)
				j = 0;
			
			while(magicSquare[i][j] != 0 && notFull())
			{
				i++;
				if(i >= magicSquare.length)
					i = 0;
			}
		}
		while(notFull());
	}
	
	private void generateEvenSquare()
	{
		int currentValue = 0;
		
		for(int i = 0; i < magicSquare.length; i++)
			for(int j = 0; j < magicSquare[i].length; j++)
				magicSquare[i][j] = ++currentValue;
		
		for(int i = 0; i < (magicSquare.length/2+1) - 1; i++)
		{
			int j = (magicSquare.length-1)-i;
			int temp = magicSquare[i][i];
			magicSquare[i][i] = magicSquare[j][j];
			magicSquare[j][j] = temp;
			
			temp = magicSquare[i][j];
			magicSquare[i][j] = magicSquare[j][i];
			magicSquare[j][i] = temp;
		}
	}
	
	private boolean notFull()
	{
		for(int i = 0; i < magicSquare.length; i++)
		{
			for(int j = 0; j < magicSquare[i].length; j++)
			{
				if(magicSquare[i][j] == 0)
					return true;
			}
		}
		
		return false;
	}
}
