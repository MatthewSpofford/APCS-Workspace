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
	 * 1. Set the min index to first array index, and max index to last
	 *    array index (exclusive).
	 * 2. Read middle number between the min and max index.
	 *    a. If the number being searched for is less than the current 
	 *       number, set the max index to the current position.
	 *    b. If the number being searched for is greater than the current
	 *       number, set the min index to one over from the current position.
	 *    c. If the number being searched for is equal to the current 
	 *       number, output the current numbers position and stop.
	 * 3. Repeat step 2 until the difference between the min and max is
	 *    less than or equal to zero.
	 * 4. Output -1 and stop.
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
		
		while((maxIndex - minIndex) > 0) {
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
