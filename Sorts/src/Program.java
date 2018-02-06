
public class Program {

	public static void main(String[] args)
	{
		int[] array = arrayInit();
		System.out.println("--BUBBLE SORT--");
		printArray(array);
		Long prevTime = System.nanoTime();
		BubbleSort.sort(array);
		Long diffTime = System.nanoTime() - prevTime;
		printArray(array);
		System.out.println("Took " + (diffTime.doubleValue() /  1000000000.0) + " seconds");
		
		System.out.println("\n--INSERTION SORT--");
		array = arrayInit();
		printArray(array);
		prevTime = System.nanoTime();
		InsertionSort.sort(array);
		diffTime = System.nanoTime() - prevTime;
		printArray(array);
		System.out.println("Took " + (diffTime.doubleValue() /  1000000000.0) + " seconds");
		
		System.out.println("\n--SELECTION SORT--");
		array = arrayInit();
		printArray(array);
		prevTime = System.nanoTime();
		SelectionSort.sort(array);
		diffTime = System.nanoTime() - prevTime;
		printArray(array);
		System.out.println("Took " + (diffTime.doubleValue() /  1000000000.0) + " seconds");
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
}
