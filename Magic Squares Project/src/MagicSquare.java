
public class MagicSquare {

	private int[][] magicSquare;
	private int squareSize;
	private int magicSum;
	
	public MagicSquare()
	{
		magicSquare = new int[3][3];
		squareSize = 3;
		generateSquare();
	}
	
	public MagicSquare(int sideLength)
	{
		if(sideLength < 3)
			sideLength = 3;
		
		if(sideLength % 2 == 0)
			sideLength += 1;
		
		magicSquare = new int[sideLength][sideLength];
		squareSize = sideLength;
		generateSquare();
	}
	
	/**
	 * Returns if the magicSquare was valid or not, meaning that the sum values of the
	 * diagonals, rows, and columns are equal.
	 * @return True if the magicSquare is valid, false if the magicSquare is invalid.
	 */
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
	/**
	 * Outputs
	 * @return Outputs a 
	 */
	public String toString()
	{
		String output = "";
		
		for(int[] row : magicSquare)
		{
			for(int col : row)
				output += col + "	";
			output += "\n";
		}
		
		return output;
	}
	
	/**
	 * Outputs the size of the magicSquare. Ex: 3x3 square outputs 3.
	 * @return Size of square as an integer value.
	 */
	public int getSize()
	{
		return squareSize;
	}
	
	/**
	 * Outputs the magic sum of the magicSquare.
	 * @return Magic sum of the square as an integer value.
	 */
	public int getSum()
	{
		return magicSum;
	}
	
	/**
	 * Generates a magic square based off of the current size of the stored magicSquare.
	 * This method cannot be run if the magicSquare is uninitialized.  This method also
	 * initializes the magic sum of the magicSquare.
	 */
	private void generateSquare()
	{
		int currentVal = 0;
		int rowIndex = 0;
		int colIndex = (magicSquare[0].length / 2);;
		
		do
		{
			magicSquare[rowIndex--][colIndex++] = ++currentVal;
			
			if(rowIndex < 0)
				rowIndex = magicSquare.length - 1;
			if(colIndex >= magicSquare[0].length)
				colIndex = 0;
			
			while(magicSquare[rowIndex][colIndex] != 0 && notFull())
			{
				rowIndex++;
				if(rowIndex >= magicSquare.length)
					rowIndex = 0;
			}
		}
		while(notFull());
		
		int sum = 0;
		for(int i = 0; i < magicSquare.length; i++)
			sum += magicSquare[i][0];
		
		magicSum = sum;
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
