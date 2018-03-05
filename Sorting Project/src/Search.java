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
		
		//Loop through the array of data to find the given number
		for(int i = 0; i < list.length; i++) {
			//Return the first instance of the given number
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
		
		//Stores the minimum index of the segment of the array being searched
		int minIndex = 0;
		//Stores the maximum index of the segment of the array being searched
		int maxIndex = list.length;
		
		while((maxIndex - minIndex) > 0) {
			//Set the current index to the center of the segment of the array being searched
			int currentIndex = (maxIndex - minIndex)/2 + minIndex;
			
			//If the number has been found, return the current index
			if(list[currentIndex] == num) {
				return currentIndex;
			}
			//If the current number is less than the number being searched for, decrease the max index
			else if(list[currentIndex] > num) {
				maxIndex = currentIndex;
			}
			//If the current number is greater than the number being searched for, increase the min index
			else {
				minIndex = currentIndex + 1;
			}
		}
		
		return -1;
	}
}
