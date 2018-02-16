
public class Program {

	public static void main(String[] args)
	{
		int[] array = null;
		Sorts sort = new BubbleSort();			//O(n^2)
		printArraySort(array, sort, "Bubble");
		
		sort = new InsertionSort();				//O(n^2)
		printArraySort(array, sort, "Insertion");

		sort = new SelectionSort();				//O(n^2)
		printArraySort(array, sort, "Selection");
		
		sort = new MergeSort();					//O(n log n)
		printArraySort(array, sort, "Merge");
		
		sort = new QuickSort();					//O(n log n) = best, O(n^2) = worst
		printArraySort(array, sort, "Quick");
	}
	
	public static int[] arrayInit(int size)
	{
		int[] array = new int[size];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = i;
		}
		boolean[] check = new boolean[size];
		for(int i = 0; i < check.length; i++)
		{
			check[i] = false;
		}
		
		int[] output = new int[size];
		int index = 0;
		while(index < output.length)
		{
			int pos = (int) (Math.random() * array.length);
			
			if(!check[pos])
			{
				output[index++] = array[pos];
				check[pos] = true;
			}
		}
		
		return output;
	}
	
	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + "  ");
		}
		System.out.print("\n");
	}
	
	public static void printArraySort(int[] array, Sorts sort, String name)
	{
		System.out.println("\n--"+ name.toUpperCase() +" SORT--");
		array = arrayInit(100000);
		printArray(array);
		Long prevTime = System.nanoTime();
		sort.sort(array);
		Long diffTime = System.nanoTime() - prevTime;
		printArray(array);
		System.out.println("Took " + (diffTime.doubleValue() /  1000000000.0) + " seconds");
	}
}
