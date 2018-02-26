/******************************************************************
 * A Project of Sorts
 * 
 * Implements Search 
 * Algorithms on integer arrays 
 * Includes Linear and Binary searches 
 * Binary Search requires a sorted list 
 * All Search methods are static
 * All Search helper methods are private
 * 
 * @author
 *
 *******************************************************************/
public class Search {
	/**
	 * Implements a Linear Search 
	 * 1. Iterate through given list
	 * 2. If the number you are searching for is found, 
	 * 	  output the index and stop
	 * 3. Else go back to step 1 until the list is fully iterated through
	 * 4. Output negative 1 if the list has been fully iterated through
	 * 
	 * @param list
	 *            - integer list to search in
	 * @param num
	 *            - integer to search for
	 * @return index of found item, -1 if not found
	 */
	public static int linearSearch(int[] list, int num) {
		
		for(int i = 0; i < list.length; i++) {
			if(list[i] == num) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Implements a Binary Search 
	 * 1. Start at the middle of the list
	 * 2. 
	 * 2. If the number being search for is less than the current number,
	 * 
	 * Pre: list must be sorted
	 * 
	 * @param list
	 *            - integer list to search in
	 * @param num
	 *            - integer to search for
	 * @return index of found item, -1 if not found
	 */
	public static int binarySearch(int[] list, int num) {
		
		int minIndex = 0;
		int maxIndex = list.length;
		
		while((maxIndex - minIndex) >= 0) {
			int currentIndex = (maxIndex - minIndex)/2 + minIndex;
			
			if(list[currentIndex] == num) {
				return currentIndex;
			}
			else if(list[currentIndex] > num) {
				maxIndex = currentIndex;
			}
			else {
				minIndex = currentIndex + 1;
			}
		}
		
		return -1;
	}
}
