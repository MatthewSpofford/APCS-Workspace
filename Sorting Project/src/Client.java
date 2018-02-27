/******************************************************************
 * This class runs a sorting program, and outputs the required data.
 * 
 * @author Matthew Spofford
 *
 *******************************************************************/
public class Client {

	private static final int PART_1_START = -20;
	private static final int PART_1_END = 20;
	private static final int PART_1_LENGTH = 20;
	
	/**
	 * This method runs a sorting program.
	 * @param args - Command line arguments that were used
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------1. SORTS AND SEARCHES TESTING-------------");
		
		System.out.println("\nBUBBLE SORT:");
		int[] array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.bubbleSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nINSERTION SORT:");
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.insertionSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nSELECTION SORT:");
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.selectionSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nMERGE SORT:");
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.mergeSort(array);
		System.out.println("End 	= " + arrayToString(array));

		System.out.println("\nQUICK SORT:");
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Start 	= " + arrayToString(array));
		Sort.quickSort(array);
		System.out.println("End 	= " + arrayToString(array));
		
		System.out.println("\nLINEAR SEARCH:");
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Array 	= " + arrayToString(array));
		int num = (int) (Math.random() * PART_1_END + PART_1_START); 
		System.out.println("Number Being Search = " + num);
		int index = Search.linearSearch(array, num);
		System.out.println("Index 	= " + index);
		
		System.out.println("\nBINARY SEARCH:");
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		System.out.println("Array Pre Sort 	= " + arrayToString(array));
		Sort.quickSort(array);
		System.out.println("Array Post Sort	= " + arrayToString(array));
		num = (int) (Math.random() * PART_1_END + PART_1_START); 
		System.out.println("Number Being Searched = " + num);
		index = Search.binarySearch(array, num);
		System.out.println("Index	= " + index);
		
		System.out.println("\n\n-------------2. SORT TIMING-------------\n");
		
		timeAllSorts(1, 1000, 1000);
		timeAllSorts(1, 5000, 5000);
		timeAllSorts(1, 100000, 10000);
		timeAllSorts(1, 500000, 50000);
		
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
		int range = endRange - startRange + 1;
		int[] output = new int[size];
		for(int i = 0; i < output.length; i++)
		{
			output[i] = (int) (Math.random() * range) + startRange;
		}
		
		return output;
	}
	
	/**
	 * Generates an identical copy of a given array.
	 * Pre: Array cannot be NULL.
	 * Post: New array is output.
	 * 
	 * @param array - integer array that is being copied.
	 * @return - integer array that was generated from the given array,
	 */
	public static int[] copyArray(int[] array)
	{
		int[] output = new int[array.length];
		for(int i = 0; i < output.length; i++)
		{
			output[i] = array[i];
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
	
	/**
	 * Times all of the sorting algorithms for an array of 
	 * a given size and range.
	 * Pre: startRange must be less than endRange, and must be integers.
	 * 		Size cannot be less than 0.
	 * Post: Prints a table of how long (milliseconds) each sort took for the array,
	 *       and titles the table with the array size
	 * 
	 * @param startRange - Starting value for the range.
	 * @param endRange - Ending value for the range.
	 * @param size - is the size of the array being created. Cannot be less than 0.
	 */
	public static void timeAllSorts(int startRange, int endRange, int size)
	{
		int[] array = arrayInit(startRange, endRange, size);
		int[] copy = copyArray(array);
		
		//Starts timing for bubble sort
		StopWatch1 stopwatch = new StopWatch1();
		stopwatch.start();
		Sort.bubbleSort(copy);
		stopwatch.stop();
		long bubbleTime = stopwatch.getElapsedTime();
		
		//Starts timing for insertion sort
		stopwatch = new StopWatch1();
		stopwatch.start();
		Sort.insertionSort(copy);
		stopwatch.stop();
		long insertionTime = stopwatch.getElapsedTime();
		
		//Starts timing for selection sort
		stopwatch = new StopWatch1();
		stopwatch.start();
		Sort.selectionSort(copy);
		stopwatch.stop();
		long selectionTime = stopwatch.getElapsedTime();
		
		//Starts timing for merge sort
		stopwatch = new StopWatch1();
		stopwatch.start();
		Sort.mergeSort(copy);
		stopwatch.stop();
		long mergeTime = stopwatch.getElapsedTime();
		
		//Starts timing for quick sort
		stopwatch = new StopWatch1();
		stopwatch.start();
		Sort.quickSort(copy);
		stopwatch.stop();
		long quickTime = stopwatch.getElapsedTime();
		
		System.out.println("|-----------------------|");
		System.out.println("|Size " + size + " Array\t|");
		System.out.println("|-----------------------|");
		System.out.println("|BUBBLE\t\t| " + bubbleTime + "\t|");
		System.out.println("|INSERTION\t| " + insertionTime + "\t|");
		System.out.println("|SELECTION\t| " + selectionTime + "\t|");
		System.out.println("|MERGE\t\t| " + mergeTime + "\t|");
		System.out.println("|QUICK\t\t| " + quickTime + "\t|");
		System.out.println("|-----------------------|\n");
	}
}
