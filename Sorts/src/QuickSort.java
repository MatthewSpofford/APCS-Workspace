
public class QuickSort implements Sorts{
	
	public void sort(int[] array)
	{
		doQuickSort(array, array.length/2, 0, array.length);
	}
	
	private void doQuickSort(int[] array, int pivot, int start, int end)
	{
		if(end - start <= 1)
		{
			return;
		}
		else
		{
			int val = array[pivot];
			int startIndex;
			int endIndex = end - 1;
			for(startIndex = start; startIndex < end && startIndex > endIndex; startIndex++)
			{
				if(array[startIndex] >= val && array[endIndex] <= val)
				{
					int temp = array[startIndex];
					array[startIndex] = array[endIndex];
					array[endIndex++] = temp;
				}
			}
			
			doQuickSort(array, (startIndex - start)/2, start, startIndex);
			doQuickSort(array, , startIndex, end);
			return;
		}
	}
}

