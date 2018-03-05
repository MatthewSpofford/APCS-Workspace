/******************************************************************
 * A Project of Sorts
 * 
 * Implements Sort Algorithms on integer arrays Includes Bubble, Insertion,
 * Selection, Merge, and Quick Sorts Merge and Quick Sorts are recursive All
 * Sort methods are static All Sort helper methods are private
 * 
 * @author
 *
 *******************************************************************/
public class Sort {

	/************************
	 * Implements Bubble Sort 
	 * 1.Scan list and compare adjacent elements 
	 * 2.Swap if out of order and set a flag 
	 * 3.Repeat 1-2 until no swaps are made (flag is false) scanning one less at the end each pass 
	 * Pre: unsorted array parameter
	 * Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void bubbleSort(int[] aSort) {
		//Represents if the array did any swapping during the last loop through
		boolean noSwap = false;
		while (!noSwap) {
			//Set no swap to true so that if no swaps occur this time, the sort will complete 
			noSwap = true;
			//Loop through the given array and swap the two numbers adjacent to each other
			//if the number towards the front is greater than the one towards the end
			for (int i = 0; i < aSort.length - 1; i++) {
				if (aSort[i] > aSort[i + 1]) {
					int temp = aSort[i + 1];
					aSort[i + 1] = aSort[i];
					aSort[i] = temp;
					noSwap = false;
				}
			}
		}
	}

	/************************
	 * Implements Insertion Sort 
	 * 1. Start with a sorted list of one value 
	 * 2. Add another value and sort the values, placing in correct 
	 * 	location 
	 * 3. Repeat 2-3, shifting sorted values to the right until it
	 *  is placed in the correct position 
	 * Pre: unsorted array parameter 
	 * Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void insertionSort(int[] aSort) {
		//Loop through the array and complete insertion sort
		for (int i = 0; i < aSort.length; i++) {
			//Create a partition from the current position
			int maxIndex = i;
			int value = aSort[i];
			//Find the number greater than the current number in the partition
			for (int j = i; j >= 0; j--) {
				if (aSort[j] > aSort[i])
					maxIndex = j;
			}
			//Insert the current number before the greatest number i the partition
			for (int k = i; k > maxIndex; k--) {
				aSort[k] = aSort[k - 1];
			}
			aSort[maxIndex] = value;
		}
	}

	/************************
	 * Implements Selection Sort 
	 * 1.Scan the list to find the smallest value 
	 * 2.Swap with first position 
	 * 3.Repeat 1-2 Scanning and swapping with the next position in the list 
	 * until you are at the end of the list 
	 * Pre: given array is not null, and can be unsorted parameter 
	 * Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void selectionSort(int[] aSort) {
		//Loop through the array and use selection sort
		for (int i = 0; i < aSort.length; i++) {
			int minIndex = i;
			//Find the smallest value in the array
			for (int j = i; j < aSort.length; j++) {
				if (aSort[j] < aSort[minIndex])
					minIndex = j;
			}
			//Swap the smallest value with the value at the current index
			int temp = aSort[minIndex];
			aSort[minIndex] = aSort[i];
			aSort[i] = temp;
		}
	}

	/************************
	 * Implements Merge Sort recursively 
	 * 1.Divide the list in half 
	 * 2.Sort each half (recursively) 
	 * 3.Merge the two sorted lists Note: Use indexes into the 
	 * array to mark two sublists and a temporary array when merging 
	 * Pre: unsorted array parameter 
	 * Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void mergeSort(int[] aSort) {
		// Sort the entire list using a recursive merge sort method
		doMergeSort(aSort, 0, aSort.length);
	}

	/**
	 * Uses the recursive merge sort algorithm to sort the given array.
	 * Pre:	Start is less than or equal to end. Start signifies the beginning index
	 * 		of the partition being looked at, and is within the array. End signifies 
	 * 		the end of the array, and is the end index of the array (exclusive).
	 * Post: Sorted the array that was given
	 * 
	 * @param array - Is the array being sorted
	 * @param start - Is the starting index of the array being sorted
	 * @param end - Is the ending index of the array being sorted (exclusive)
	 */
	private static void doMergeSort(int[] array, int start, int end) {
		//If the partition is one number, than the partition is sorted
		if (end - start <= 1) {
			return;
		}
		//Else, merge two partitions together
		else {
			//Create two partitions from the center of the current partition
			int aStart = start;
			int aEnd = (end + start) / 2;
			int bStart = (end + start) / 2;
			int bEnd = end;
			//Merge sort these newly created partitions
			doMergeSort(array, aStart, aEnd);
			doMergeSort(array, bStart, bEnd);
			//Merges the two partitions
			merge(array, aStart, aEnd, bStart, bEnd);
			return;
		}
	}

	/**
	 * Merges two partitions into one.
	 * Pre:	Both a and b start is less or equal to the corresponding end. Both starts 
	 * 		signifies the beginning index of the partition being looked at, and is within 
	 * 		the array. Both ends signifies the end of the array, and is the end index of 
	 * 		the array (exclusive).
	 * Post: Modifies the given array by merging the two partitions
	 * 
	 * @param array - Is the given array being sorted
	 * @param aStart - Is the start index of the A partition
	 * @param aEnd - Is the end index of the A partition
	 * @param bStart - Is the start index of the B partition
	 * @param bEnd - Is the end index of the B partition
	 */
	private static void merge(int[] array, int aStart, int aEnd, int bStart, int bEnd) {
		//Stores array of merged partitions that will be replacing the two partitions in the given array
		int[] output = new int[(aEnd - aStart) + (bEnd - bStart)];
		int aIndex = aStart;
		int bIndex = bStart;
		int index = 0;
		//While within the array being merged...
		while (index < output.length) {
			//If the first partition has been fully merged, merge the rest of the second partition
			if (aIndex >= aEnd) {
				for (int i = bIndex; i < bEnd; i++)
					output[index++] = array[i];
			}
			//If the second partition has been fully merged, merge the rest of the first partition
			else if (bIndex >= bEnd) {
				for (int i = aIndex; i < aEnd; i++)
					output[index++] = array[i];
			} 
			//If both partitions are still being merged together...
			else {
				//If the number being looked at in the first partition is smaller than the one in the second, 
				//add it into the merged array
				if (array[aIndex] < array[bIndex]) {
					output[index++] = array[aIndex++];
				}
				//If the number being looked at in the second partition is smaller than the one in the first,
				//add it into the merged array
				else {
					output[index++] = array[bIndex++];
				}
			}
		}

		//Copy merged array into the given array
		for (int i = 0; i < output.length; i++) {
			array[i + aStart] = output[i];
		}
	}

	/************************
	 * Implements Quick Sort recursively 
	 * 1.Divide into two sublists, < and > a pivot value 
	 * 2.Recursively sort each sublist Use the first element in the list as
	 * the pivot Note: Use indexes into the array to mark two sublists 
	 * Pre: unsorted array parameter 
	 * Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void quickSort(int[] aSort) {
		// Sort the entire list using the recursive merge sort method
		doQuickSort(aSort, 0, aSort.length);
	}

	/**
	 * Uses the recursive quick sort algorithm to sort the given array.
	 * Pre:	Start is less than or equal to end. Start signifies the beginning index
	 * 		of the partition being looked at, and is within the array. End signifies 
	 * 		the end of the array, and is the end index of the array (exclusive).
	 * Post: Sorted the array that was given
	 * 
	 * @param array - Is the array being sorted
	 * @param start - Is the starting index of the array being sorted
	 * @param end - Is the ending index of the array being sorted (exclusive)
	 */
	private static void doQuickSort(int[] array, int start, int end)
	{
		//If the partition is one number, than the partition is sorted
		if(end - start <= 1)
		{
			return;
		}
		else
		{
			//Pivot is within the center of the partition being looked at
			int pivot = (end - start)/2 + start;
			//Store the number at the pivot location
			int val = array[pivot];
			//Represents the starting number of the partition
			int startIndex = start;
			//Represents the last number of the partition
			int endIndex = end - 1;
			//Loop through the current partition
			while(startIndex < end && startIndex <= endIndex)
			{
				//If the number being looked at towards the start of the partition is greater than or equal
				//to the pivot value, and the number towards the end of the partition is less than or equal to
				//the pivot, swap the numbers
				if(array[startIndex] >= val && array[endIndex] <= val)
				{
					int temp = array[startIndex];
					array[startIndex++] = array[endIndex];
					array[endIndex--] = temp;
				}
				else
				{
					//If the number towards the start of the partition is already less than the pivot value,
					//keep looking further up the array
					if(array[startIndex] < val)
					{
						startIndex++;
					}
					//If the number towards the end of the partition is already greater than the pivot value,
					//keep looking further down the array
					if(array[endIndex] >= val)
					{
						endIndex--;
					}
				}
			}
			
			//Create two new partitions and continue sorting until the sort is finished
			doQuickSort(array, start, startIndex);
			doQuickSort(array, startIndex, end);
			return;
		}
	}
}
