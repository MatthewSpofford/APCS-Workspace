
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
			int startIndex = start;
			int endIndex = end - 1;
//			printArray(array);
			while(startIndex < end && startIndex <= endIndex)
			{
				if(array[startIndex] > val && array[endIndex] <= val)
				{
					int temp = array[startIndex];
					array[startIndex++] = array[endIndex];
					array[endIndex--] = temp;
				}
				if(array[startIndex] < val)
				{
					startIndex++;
				}
				if(array[endIndex] >= val)
				{
					endIndex--;
				}
			}
			
			doQuickSort(array, (startIndex - start)/2 + start, start, startIndex);
			doQuickSort(array, (end - startIndex)/2 + startIndex, startIndex, end);
			return;
		}
	}
	
	public void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
		System.out.println("\n");
	}
}
