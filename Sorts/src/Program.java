
public class Program {

	public static void main(String[] args)
	{
		int[] array = arrayInit();
		System.out.println("--BUBBLE SORT--");
		printArray(array);
		BubbleSort.sort(array);
		printArray(array);
		
		System.out.println("\n--INSERTION SORT--");
		array = arrayInit();
		printArray(array);
		InsertionSort.sort(array);
		printArray(array);
		
		System.out.println("\n--SELECTION SORT--");
		array = arrayInit();
		printArray(array);
		SelectionSort.sort(array);
		printArray(array);
	}
	
	public static int[] arrayInit()
	{
		int[] array = {10, 4, 7, 9, 6, 3, 12, 5, 2, 1, 11, 8};
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
