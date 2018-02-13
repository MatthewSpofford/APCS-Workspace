
public class Program {

	public static void main(String[] args)
	{
		int[] array = arrayInit();
		Sorts sort = new BubbleSort();			//O(n^2) or O(289)
		printData(array, sort, "Bubble");
		
		sort = new InsertionSort();				//O(n^2) or O(289)
		printData(array, sort, "Insertion");

		sort = new SelectionSort();				//O(n^2) or O(289)
		printData(array, sort, "Selection");
		
		sort = new MergeSort();					//O(n log n) or O(20.918)
		printData(array, sort, "Merge");
		
		sort = new QuickSort();					//O(n log n) = best, O(n^2) = worst or O(20.918) = best, O(289) = worst
		printData(array, sort, "Quick");
	}
	
	public static int[] arrayInit()
	{
		int[] array = {10, 14, 4, 16, 7, 9, 13, 6, 3, 12, 5, 2, 15, 1, 11, 8, 0};
		return array;
	}
	
	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + "  ");
		}
		System.out.print("\n");
	}
	
	public static void printData(int[] array, Sorts sort, String name)
	{
		System.out.println("\n--"+ name.toUpperCase() +" SORT--");
		array = arrayInit();
		printArray(array);
		Long prevTime = System.nanoTime();
		sort.sort(array);
		Long diffTime = System.nanoTime() - prevTime;
		printArray(array);
		System.out.println("Took " + (diffTime.doubleValue() /  1000000000.0) + " seconds");
	}
}
