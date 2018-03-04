/******************************************************************
 * This class runs a sorting program, and outputs the required data.
 * 
 * @author Matthew Spofford
 *
 *******************************************************************/
public class Client {

	//Flags representing what sorts will be used for sortArray()
	private static final int BUBBLE_SORT = 1;
	private static final int INSERTION_SORT = 2;
	private static final int SELECTION_SORT = 3;
	private static final int MERGE_SORT = 4;
	private static final int QUICK_SORT = 5;
	
	//Flags representing what searches will be used for searchArray()
	private static final int LINEAR_SEARCH = 1;
	private static final int BINARY_SEARCH = 2;
	
	//Flags for time sort methods representing how the array being sorted should be setup
	private static final int TIME_RANDOM = 0;
	private static final int TIME_SORTED = 1;
	private static final int TIME_REVERSE_SORT = 2;
	
	private static final int PART_1_START = -20;
	private static final int PART_1_END = 20;
	private static final int PART_1_LENGTH = 20;
	
	/**
	 * This method runs a sorting program.
	 * @param args - Command line arguments that were used
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------1. SORTS AND SEARCHES TESTING-------------");
		
		int[] array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		sortArray(array, BUBBLE_SORT, true);
		
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		sortArray(array, INSERTION_SORT, true);
		
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		sortArray(array, SELECTION_SORT, true);
		
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		sortArray(array, MERGE_SORT, true);
		
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		sortArray(array, QUICK_SORT, true);
		
		int num = (int) (Math.random() * PART_1_END + PART_1_START);
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		searchArray(array, LINEAR_SEARCH, num, true);

		num = (int) (Math.random() * PART_1_END + PART_1_START);
		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
		searchArray(array, BINARY_SEARCH, num, true);
		
//		System.out.println("\nLINEAR SEARCH:");
//		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
//		System.out.println("Array 	= " + arrayToString(array));
//		int num = (int) (Math.random() * PART_1_END + PART_1_START); 
//		System.out.println("Number Being Search = " + num);
//		int index = Search.linearSearch(array, num);
//		System.out.println("Index 	= " + index);
//		
//		System.out.println("\nBINARY SEARCH:");
//		array = arrayInit(PART_1_START, PART_1_END, PART_1_LENGTH);
//		System.out.println("Array Pre Sort 	= " + arrayToString(array));
//		Sort.quickSort(array);
//		System.out.println("Array Post Sort	= " + arrayToString(array));
//		num = (int) (Math.random() * PART_1_END + PART_1_START); 
//		System.out.println("Number Being Searched = " + num);
//		index = Search.binarySearch(array, num);
//		System.out.println("Index	= " + index);
		
		System.out.println("\n\n-------------2. SORT TIMING-------------\n");
		
		timeAllSorts(1, 1000, 1000, TIME_RANDOM);
		timeAllSorts(1, 5000, 5000, TIME_RANDOM);
		timeAllSorts(1, 100000, 10000, TIME_RANDOM);
		timeAllSorts(1, 500000, 50000, TIME_RANDOM);
		timeAllButBubbleSorts(1, 100000, 100000, TIME_RANDOM);
		timeAllButBubbleSorts(1, 500000, 500000, TIME_RANDOM);
		timeMergeAndQuickSorts(1, 100000000, 100000000, TIME_RANDOM);
		timeMergeAndQuickSorts(1, 500000000, 500000000, TIME_RANDOM);
		
		System.out.println("\n\n-------------3. TYPES OF LIST TIMING-------------\n");
		
		timeAllButBubbleSorts(1, 200000, 200000, TIME_RANDOM);
		timeAllButBubbleSorts(1, 200000, 200000, TIME_SORTED);
		timeAllButBubbleSorts(1, 200000, 200000, TIME_REVERSE_SORT);
		timeAllButBubbleSorts(1, 20, 200000, TIME_RANDOM);
		
		System.out.println("\n\n-------------3. SEARCH TIMING-------------\n");
		
		
		
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
	 * Reverses and sorts the give array
	 * Pre: Array cannot be NULL
	 * Post: Array given is changed to be reversed and sorted
	 * 
	 * @param array - Is the given array that will be reversed and sorted
	 */
	public static void reverseSort(int[] array)
	{
		int[] sorted = copyArray(array);
		Sort.quickSort(sorted);
		
		for(int i = 0; i <= sorted.length/2; i++)
		{
			int temp = sorted[i];
			sorted[i] = sorted[(sorted.length - 1) - i];
			sorted[(sorted.length - 1) - i] = temp;
		}
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = sorted[i];
		}
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
	 * Sorts a given array depending on the sort given.
	 * 
	 * Pre: Given array is not null.  Sort given is valid, otherwise the array is reprinted.
	 * Post: Array before and after the sort is printed.  The given array is not modified.
	 * 
	 * @param array - Is the given array being sorted.
	 * @param sort - Is the given sort being used.
	 * 				1 = Bubble sort
	 * 				2 = Insertion sort
	 * 				3 = Selection Sort
	 * 				4 = Merge sort
	 * 				5 = Quick sort
	 * @param printOrTimeArray - 	True to print the array before and after.  
	 * 					   			False to print the time taken to do the sort.
	 */
	public static void sortArray(final int[] array, final int sort, final boolean printOrTimeArray)
	{
		int[] arrayCopy = copyArray(array);
		switch (sort) {
		case BUBBLE_SORT:
			System.out.print("\nBUBBLE SORT: ");	
			Sort.bubbleSort(arrayCopy);
			break;
		case INSERTION_SORT:
			System.out.print("\nINSERTION SORT: ");	
			Sort.bubbleSort(arrayCopy);
			break;
		case SELECTION_SORT:
			System.out.print("\nSELECTION SORT: ");	
			Sort.bubbleSort(arrayCopy);
			break;
		case MERGE_SORT:
			System.out.print("\nMERGE SORT: ");	
			Sort.bubbleSort(arrayCopy);
			break;
		case QUICK_SORT:
			System.out.print("\nQUICK SORT: ");	
			Sort.bubbleSort(arrayCopy);
		default:
			break;
		}
		
		if(printOrTimeArray) {
			System.out.println("\nStart 	= " + arrayToString(array));
			System.out.println("End 	= " + arrayToString(arrayCopy));
		}
	}
	
	/**
	 * Sorts a given array depending on the sort given.
	 * 
	 * Pre: Given array is not null.  Search given is valid, otherwise array and invalid index is output.
	 * Post: 	Array is printed, number being searched for, and its index in the array is printed.  
	 * 			For binary search, the sorted array is printed instead.  -1 is output for the index if 
	 * 			the number is not found. The given array is also not modified.
	 * 
	 * @param array - Is the given array being sorted.
	 * @param search - Is the given search being used.
	 * 					1 = Bubble sort
	 * 					2 = Binary search
	 * @param num - Number being search for in the array.
	 * @param printOrTimeArray - 	True to print the array, number being searched for, and its index.  
	 * 					   			False to print the time taken to do the search.
	 */
	public static void searchArray(final int[] array, final int search, final int num, final boolean printOrTimeArray)
	{
		//Index is set to negative one so that if search given is invalid, index will also be invalid
		int index = -1;
		//The only reason for copy is so that binary search works correctly
		int[] arrayCopy = copyArray(array);
		
		switch (search) {
		case LINEAR_SEARCH:
			System.out.print("\nLINEAR SEARCH: ");
			index = Search.linearSearch(arrayCopy, num);
			break;
		case BINARY_SEARCH:
			System.out.print("\nBINARY SEARCH: ");
			Sort.quickSort(arrayCopy);
			index = Search.binarySearch(arrayCopy, num);
			break;
		default:
			break;
		}
		
		if(printOrTimeArray) {
			System.out.println("\nArray = " + arrayToString(arrayCopy));
			System.out.println("Number Being Searched = " + num);
			System.out.println("Index = " + index);
		} else {
			
		}
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
	 * @param flag - Sets up the array being sorted based off of the given value
	 * 				0 - Randomly sorts the array before sorting
	 * 				1 - Sorts the array before sorting
	 * 				2 - Reverse sorts the array before sorting
	 */
	public static void timeAllSorts(int startRange, int endRange, int size, int flag)
	{
		int[] array = arrayInit(startRange, endRange, size);
		
		if(flag == TIME_RANDOM) {
			//Do nothing
		} else if(flag == TIME_SORTED) {
			Sort.quickSort(array);
		} else if(flag == TIME_REVERSE_SORT) {
			reverseSort(array);
		}
		
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
		
		if(flag == TIME_RANDOM) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is random before\t\t|");
			System.out.println("|-------------------------------|");
		} else if(flag == TIME_SORTED) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is sorted before\t|");
			System.out.println("|-------------------------------|");
		} else if(flag == TIME_REVERSE_SORT) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is reverse sorted before\t|");
			System.out.println("|-------------------------------|");
		}
		
		System.out.println("|" + startRange + "-" + endRange + ", Size " + size + " Array\t|");
		System.out.println("|-------------------------------|");
		System.out.println("|Sort\t\t| Millisecs\t|");
		System.out.println("|-------------------------------|");
		System.out.println("|BUBBLE\t\t| " + bubbleTime + "\t\t|");
		System.out.println("|INSERTION\t| " + insertionTime + "\t\t|");
		System.out.println("|SELECTION\t| " + selectionTime + "\t\t|");
		System.out.println("|MERGE\t\t| " + mergeTime + "\t\t|");
		System.out.println("|QUICK\t\t| " + quickTime + "\t\t|");
		System.out.println("|-------------------------------|\n");
	}
	
	/**
	 * Times all of the sorting algorithms except bubble for an array of 
	 * a given size and range.
	 * Pre: startRange must be less than endRange, and must be integers.
	 * 		Size cannot be less than 0.
	 * Post: Prints a table of how long (milliseconds) each sort took for the array,
	 *       and titles the table with the array size
	 * 
	 * @param startRange - Starting value for the range.
	 * @param endRange - Ending value for the range.
	 * @param size - is the size of the array being created. Cannot be less than 0.	 
	 * @param flag - Sets up the array being sorted based off of the given value
	 * 				0 - Randomly sorts the array before sorting
	 * 				1 - Sorts the array before sorting
	 * 				2 - Reverse sorts the array before sorting
	 */
	public static void timeAllButBubbleSorts(int startRange, int endRange, int size, int flag)
	{
		int[] array = arrayInit(startRange, endRange, size);
		
		if(flag == TIME_RANDOM) {
			//Do nothing
		} else if(flag == TIME_SORTED) {
			Sort.quickSort(array);
		} else if(flag == TIME_REVERSE_SORT) {
			reverseSort(array);
		}
		
		int[] copy = copyArray(array);
		
		//Starts timing for insertion sort
		StopWatch1 stopwatch = new StopWatch1();
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
		
		if(flag == TIME_RANDOM) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is random before\t\t|");
			System.out.println("|-------------------------------|");
		} else if(flag == TIME_SORTED) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is sorted before\t|");
			System.out.println("|-------------------------------|");
		} else if(flag == TIME_REVERSE_SORT) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is reverse sorted before\t|");
			System.out.println("|-------------------------------|");
		}
		
		System.out.println("|" + startRange + "-" + endRange + ", Size " + size + " Array\t|");
		System.out.println("|-------------------------------|");
		System.out.println("|Sort\t\t| Millisecs\t|");
		System.out.println("|-------------------------------|");
		System.out.println("|INSERTION\t| " + insertionTime + "\t\t|");
		System.out.println("|SELECTION\t| " + selectionTime + "\t\t|");
		System.out.println("|MERGE\t\t| " + mergeTime + "\t\t|");
		System.out.println("|QUICK\t\t| " + quickTime + "\t\t|");
		System.out.println("|-------------------------------|\n");
	}
	
	/**
	 * Times all of the sorting algorithms except bubble for an array of 
	 * a given size and range.
	 * Pre: startRange must be less than endRange, and must be integers.
	 * 		Size cannot be less than 0.
	 * Post: Prints a table of how long (milliseconds) each sort took for the array,
	 *       and titles the table with the array size
	 * 
	 * @param startRange - Starting value for the range.
	 * @param endRange - Ending value for the range.
	 * @param size - is the size of the array being created. Cannot be less than 0.
	 * @param flag - Sets up the array being sorted based off of the given value
	 * 				0 - Randomly sorts the array before sorting
	 * 				1 - Sorts the array before sorting
	 * 				2 - Reverse sorts the array before sorting
	 */
	public static void timeMergeAndQuickSorts(int startRange, int endRange, int size, int flag)
	{
		int[] array = arrayInit(startRange, endRange, size);
		
		if(flag == TIME_RANDOM) {
			//Do nothing
		} else if(flag == TIME_SORTED) {
			Sort.quickSort(array);
		} else if(flag == TIME_REVERSE_SORT) {
			reverseSort(array);
		}
		
		int[] copy = copyArray(array);
		
		//Starts timing for merge sort
		StopWatch1 stopwatch = new StopWatch1();
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
		
		if(flag == TIME_RANDOM) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is random before\t\t|");
			System.out.println("|-------------------------------|");
		} else if(flag == TIME_SORTED) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is sorted before\t|");
			System.out.println("|-------------------------------|");
		} else if(flag == TIME_REVERSE_SORT) {
			System.out.println("|-------------------------------|");
			System.out.println("|Array is reverse sorted before\t|");
			System.out.println("|-------------------------------|");
		}
		
		System.out.println("|" + startRange + "-" + endRange + ", Size " + size + " Array\t|");
		System.out.println("|-------------------------------|");
		System.out.println("|Sort\t\t| Millisecs\t|");
		System.out.println("|-------------------------------|");
		System.out.println("|MERGE\t\t| " + mergeTime + "\t\t|");
		System.out.println("|QUICK\t\t| " + quickTime + "\t\t|");
		System.out.println("|-------------------------------|\n");
	}
	
	/**
	 * Times all of the sorting algorithms except bubble for an array of 
	 * a given size and range.
	 * Pre: startRange must be less than endRange, and must be integers.
	 * 		Size cannot be less than 0.
	 * Post: Prints a table of how long (milliseconds) each sort took for the array,
	 *       and titles the table with the array size
	 * 
	 * @param startRange - Starting value for the range.
	 * @param endRange - Ending value for the range.
	 * @param size - is the size of the array being created. Cannot be less than 0.
	 * @param flag - Sets up the array being sorted based off of the given value
	 * 				0 - Randomly sorts the array before sorting
	 * 				1 - Sorts the array before sorting
	 * 				2 - Reverse sorts the array before sorting
	 */
	public static void timeLinearSearch(int startRange, int endRange, int size, int flag)
	{
		int[] array = arrayInit(startRange, endRange, size);
		
		if(flag == TIME_RANDOM) {
			//Do nothing
		} else if(flag == TIME_SORTED) {
			Sort.quickSort(array);
		}
		
		int[] copy = copyArray(array);
	}
}
