/**
 * Class that creates and stores magic squares.
 * Can only create squares with an odd length.
 * @author Matthew Spofford
 */
public class MagicSquare {

	private int[][] magicSquare;	//Stores the magic square
	
	/**
	 * Create a magic square that is 3x3.
	 */
	public MagicSquare()
	{
		//Create a blank square that is 3x3
		magicSquare = new int[3][3];
		
		//Sets square values to zero
		initSquare();
		//Generate magic square values
		generateSquare();
	}
	
	/**
	 * Creates a magic square based off of the side length given.  The side length is
	 * set to 3 if less than that value.  If the side length is even, increase it by 1.
	 * Example: side length = 3, square = 3x3
	 * @param sideLength Represents the length of each side for the magic square
	 */
	public MagicSquare(int sideLength)
	{
		//If length is too small, set to 3
		if(sideLength < 3)
			sideLength = 3;
		
		//If length is even, increase length by 1
		if(sideLength % 2 == 0)
			sideLength += 1;
		
		//Create blank square based off of length given
		magicSquare = new int[sideLength][sideLength];
		
		//Sets square values to zero
		initSquare();
		//Generate magic square values
		generateSquare();
	}
	
	/**
	 * Returns if the magicSquare was valid or not, meaning that the sum values of the
	 * diagonals, rows, and columns are equal.
	 * @return True if the magicSquare is valid, false if the magicSquare is invalid.
	 */
	public boolean validSquare()
	{
		int currentValue = 0;	//Stores current sum of row/column/diagonal being checked
		int magicSum = 0;		//Stores the magic sum of the square
		
		//Calculate the magic sum
		for(int i = 0; i < magicSquare.length; i++)
			magicSum += magicSquare[i][0];
		
		//Checks the sum value of the rows
		for(int i = 0; i < magicSquare.length; i++)
		{
			currentValue = 0;
			for(int j = 0; j < magicSquare[i].length; j++)
			{
				currentValue += magicSquare[i][j];
			}
			
			//If a sum is not equal to the magic sum, the square is not valid
			if(currentValue != magicSum)
				return false;
		}
		
		//Checks the sum value of the columns
		for(int i = 0; i < magicSquare.length; i++)
		{
			currentValue = 0;
			for(int j = 0; j < magicSquare[i].length; j++)
			{
				currentValue += magicSquare[j][i];
			}
			
			//If a sum is not equal to the magic sum, the square is not valid
			if(currentValue != magicSum)
				return false;
		}
		
		//Checks the sum value of the top-left to bottom-right diagonal
		currentValue = 0;
		for(int i = 0, j = 0; i < magicSquare.length && j < magicSquare[0].length; i++, j++)
		{
			currentValue += magicSquare[i][j];
		}
		//If a sum is not equal to the magic sum, the square is not valid
		if(currentValue != magicSum)
			return false;
		
		//Checks the sum value of the top-right to bottom-left diagonal
		currentValue = 0;
		for(int i = 0, j = magicSquare[0].length - 1; i < magicSquare.length && j >= 0; i++, j--)
		{
			currentValue += magicSquare[i][j];
		}
		//If a sum is not equal to the magic sum, the square is not valid
		if(currentValue != magicSum)
			return false;
		
		return true;
	}
	
	/**
	 * Outputs the magic square
	 * @return Outputs the magic square as a string 
	 */
	@Override
	public String toString()
	{
		String output = "";
		
		//Loops through the magic square to be put into a string format
		for(int[] row : magicSquare)
		{
			for(int col : row) {
				output += col + "\t";
			}
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
		return magicSquare.length;
	}
	
	/**
	 * Outputs the magic sum of the magicSquare.
	 * @return Magic sum of the square as an integer value.
	 */
	public int getSum()
	{
		int magicSum = 0;
		
		//Calculate the magic sum
		for(int i = 0; i < magicSquare.length; i++)
			magicSum += magicSquare[i][0];
		
		return magicSum;
	}
	
	/**
	 * Generates a magic square based off of the current size of the stored magicSquare.
	 * This method cannot be run if the magicSquare is uninitialized.	 
	 **/
	private void generateSquare()
	{
		int currentVal = 0;		//Stores current number being added to the square
		int rowIndex = 0;		//Stores the row index
		int colIndex = (magicSquare[0].length / 2);	//Sets column index to squares middle
		
		//Loop through the magic square if it is not full
		do
		{
			int lastRowIndex = rowIndex;	//Stores the row index of the last value set
			int lastColIndex = colIndex;	//Stores the column index of the last value set
			
			//For very iteration, attempt to move the number in the northeast direction from the last
			magicSquare[rowIndex--][colIndex++] = ++currentVal;
			
			//If the row index is outside of the top of the square, bring the index to the bottom
			if(rowIndex < 0)
				rowIndex = magicSquare.length - 1;
			//If the column index is outside of the right side of the square, bring the index to the left side
			if(colIndex >= magicSquare[0].length)
				colIndex = 0;
			
			//If there is already a number within the current position being looked at,
			//go down a row until from the last position until it is empty
			if(magicSquare[rowIndex][colIndex] != 0 && notFull())
			{
				rowIndex = lastRowIndex;
				colIndex = lastColIndex;
				
				//If outside of the square boundary, go to the first row
				do
				{
					if(++rowIndex >= magicSquare.length)
						rowIndex = 0;
				}
				while(magicSquare[rowIndex][colIndex] != 0);
			}
		}
		while(notFull());
	}
	
	/**
	 * Used to find see if the magic square is still not yet complete/full
	 * @return Outputs true if the magic square is not full, and false if full
	 */
	private boolean notFull()
	{
		//Loops through the magic square to see if there are any empty sections
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

	/**
	 * Initializes values of magic square to zero
	 */
	private void initSquare()
	{
		for(int i = 0; i < magicSquare.length; i++)
			for(int j = 0; j < magicSquare[i].length; j++)
				magicSquare[i][j] = 0;
	}
}
