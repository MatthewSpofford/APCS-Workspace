
public class SelectionSort {

	public static void sort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			int minIndex = i;
			for(int j = i; j < array.length; j++)
			{
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
}
