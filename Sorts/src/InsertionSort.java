
public class InsertionSort {

	public static void sort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			int minIndex = i;
			for(int j = i; j >= 0; j--)
			{
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			
			for(int k = i; k > minIndex; k--)
			{
				array[k] = array[k - 1];
			}
			array[minIndex] = array[i];
			print(array);
		}
	}
	
	public static void print(int[] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
