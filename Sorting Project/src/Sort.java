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
		boolean noSwap = false;
		while (!noSwap) {
			noSwap = true;
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
	 * 1.Start with a sorted list of one value 
	 * 2.Add another value and sort the values, placing in correct 
	 * 	location 
	 * 3.Repeat 2-3 shifting sorted values to the right until it
	 *  is placed in the correct position 
	 * Pre: unsorted array parameter 
	 * Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void insertionSort(int[] aSort) {
		for (int i = 0; i < aSort.length; i++) {
			int maxIndex = i;
			int value = aSort[i];
			for (int j = i; j >= 0; j--) {
				if (aSort[j] > aSort[i])
					maxIndex = j;
			}
			for (int k = i; k > maxIndex; k--) {
				aSort[k] = aSort[k - 1];
			}
			aSort[maxIndex] = value;
		}
	}

	/************************
	 * Implements Selection Sort 1.Scan the list to find the smallest value 2.Swap
	 * with first position 3.Repeat 1-2 Scanning and swapping with the next position
	 * in the list Until you are at the end of the list Pre: unsorted array
	 * parameter Post: sorted array parameter
	 * 
	 * @param aSort
	 *            integer array
	 **/
	public static void selectionSort(int[] aSort) {
		for (int i = 0; i < aSort.length; i++) {
			int minIndex = i;
			for (int j = i; j < aSort.length; j++) {
				if (aSort[j] < aSort[minIndex])
					minIndex = j;
			}
			int temp = aSort[minIndex];
			aSort[minIndex] = aSort[i];
			aSort[i] = temp;
		}
	}

	/************************
	 * Implements Merge Sort recursively 1.Divide the list in half 2.Sort each half
	 * (recursively) 3.Merge the two sorted lists Note: Use indexes into the array
	 * to mark two sublists and a temporary array when merging Pre: unsorted array
	 * parameter Post: sorted array parameter
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
		if (end - start <= 1) {
			return;
		} else {
			int aStart = start;
			int aEnd = (end + start) / 2;
			int bStart = (end + start) / 2;
			int bEnd = end;
			doMergeSort(array, aStart, aEnd);
			doMergeSort(array, bStart, bEnd);
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
		int[] output = new int[(aEnd - aStart) + (bEnd - bStart)];
		int aIndex = aStart;
		int bIndex = bStart;
		int index = 0;
		while (index < output.length) {
			if (aIndex >= aEnd) {
				for (int i = bIndex; i < bEnd; i++)
					output[index++] = array[i];
			} else if (bIndex >= bEnd) {
				for (int i = aIndex; i < aEnd; i++)
					output[index++] = array[i];
			} else {
				if (array[aIndex] < array[bIndex]) {
					output[index++] = array[aIndex++];
				} else {
					output[index++] = array[bIndex++];
				}
			}
		}

		for (int i = 0; i < output.length; i++) {
			array[i + aStart] = output[i];
		}
	}

	/************************
	 * Implements Quick Sort recursively 1.Divide into two sublists, < and > a pivot
	 * value 2.Recursively sort each sublist Use the first element in the list as
	 * the pivot Note: Use indexes into the array to mark two sublists Pre: unsorted
	 * array parameter Post: sorted array parameter
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
		int pivot = (end - start)/2 + start;
		if(end - start <= 1)
		{
			return;
		}
		else
		{
			int val = array[pivot];
			int startIndex = start;
			int endIndex = end - 1;
			while(startIndex < end && startIndex <= endIndex)
			{
				if(array[startIndex] >= val && array[endIndex] <= val)
				{
					int temp = array[startIndex];
					array[startIndex++] = array[endIndex];
					array[endIndex--] = temp;
				}
				else
				{
					if(array[startIndex] < val)
					{
						startIndex++;
					}
					if(array[endIndex] >= val)
					{
						endIndex--;
					}
				}
			}
			
			doQuickSort(array, start, startIndex);
			doQuickSort(array, startIndex, end);
			return;
		}
	}
}
