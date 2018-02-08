
public class InsertionSort implements Sorts{

	public void sort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			int maxIndex = i;
			int value = array[i];
			for(int j = i; j >= 0; j--)
			{
				if(array[j] > array[i])
					maxIndex = j;
			}
			for(int k = i; k > maxIndex; k--)
			{
				array[k] = array[k - 1];
			}
			array[maxIndex] = value;
		}
	}
}
