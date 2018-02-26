/******************************************************************
 * This class runs a sorting program, and outputs the required data.
 * 
 * @author Matthew Spofford
 *
 *******************************************************************/
public class Client {

	private static final int PART_1_START = -20;
	private static final int PART_1_END = 20;
	
	/**
	 * This method runs a sorting program.
	 * @param args - Command line arguments that were used
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------1. SORTS AND SEARCHES TESTING-------------");
		
		System.out.println("\nBUBBLE SORT:");
		int[] array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.bubbleSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nINSERTION SORT:");
		array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.insertionSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nSELECTION SORT:");
		array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.selectionSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nMERGE SORT:");
		array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.mergeSort(array);
		System.out.println("End 	= " + arrayToString(array));

		System.out.println("\nQUICK SORT:");
		array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.quickSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nLINEAR SEARCH:");
		array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Array 	= " + arrayToString(array));
		int num = (int) (Math.random() * PART_1_END + PART_1_START); 
		System.out.println("Number Being Search = " + num);
		int index = Search.linearSearch(array, num);
		System.out.println("Index 	= " + index);
		
		System.out.println("\nBINARY SEARCH:");
		array = arrayInit(PART_1_START, PART_1_END);
		System.out.println("Array Pre Sort 	= " + arrayToString(array));
		Sort.quickSort(array);
		System.out.println("Array Post Sort	= " + arrayToString(array));
		num = (int) (Math.random() * PART_1_END + PART_1_START); 
		System.out.println("Number Being Search = " + num);
		index = Search.binarySearch(array, num);
		System.out.println("Index	= " + index);
		
		System.out.println("\n\n-------------2. SORTS AND SEARCH TESTING-------------");

	}
	
	
	//TODO Can there be repeats in the array init?
	
	
	/**
	 * Initializes an array of integers with random values within a range.
	 * Pre: startRange must be less than endRange, and must be integers.
	 * Post: Outputs an array of random values within a given range. 
	 * 
	 * @param startRange - Starting value for the range.
	 * @param endRange - Ending value for the range.
	 * @return - Random integer array within a range of values.
	 */
	public static int[] arrayInit(int startRange, int endRange)
	{
		int size = endRange - startRange + 1;
		int[] array = new int[size];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = startRange+i;
		}
		boolean[] check = new boolean[size];
		for(int i = 0; i < check.length; i++)
		{
			check[i] = false;
		}
		
		int[] output = new int[size];
		int index = 0;
		while(index < output.length)
		{
			int pos = (int) (Math.random() * array.length);
			
			if(!check[pos])
			{
				output[index++] = array[pos];
				check[pos] = true;
			}
		}
		
		return output;
	}
	
	/**
	 * Initializes an array of integers with random values within a range.
	 * Pre: startRange must be less than endRange, and must be integers.
	 * 		Size cannot be less than 0.
	 * Post: Outputs an array of random values within a given range. 
	 * 
	 * @param startRange - Starting value for the range.
	 * @param endRange - Ending value for the range.
	 * @param size - is the size of the array being created. Cannot be less than 0.
	 * @return - Random integer array within a range of values.
	 */
	public static int[] arrayInit(int startRange, int endRange, int size)
	{
		int[] array = new int[size];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = startRange+i;
		}
		boolean[] check = new boolean[size];
		for(int i = 0; i < check.length; i++)
		{
			check[i] = false;
		}
		
		int[] output = new int[size];
		int index = 0;
		while(index < output.length)
		{
			int pos = (int) (Math.random() * array.length);
			
			if(!check[pos])
			{
				output[index++] = array[pos];
				check[pos] = true;
			}
		}
		
		return output;
	}
	
	/**
	 * Returns the given integer array as a string.
	 * Pre: Array cannot be NULL
	 * Post: Given array is returned as a string, with two spaces in between each digit
	 * 
	 * @param array - Is the given array being printed.
	 * @return - returns
	 */
	public static String arrayToString(int[] array)
	{
		String output = "";
		for(int i = 0; i < array.length; i++)
		{
			if(i == array.length-1) {
				output += array[i];
			}
			else {
				output += array[i] + "  ";	
			}
		}
		return output;
	}
}
