
public class QuickSort implements Sorts{
	
	public void sort(int[] array)
	{
		doQuickSort(array, array.length/2, 0, array.length);
	}
	
	private void doQuickSort(int[] array, int pivot, int start, int end)
	{
//		System.out.print("\n");
//		printArray(array);
//		System.out.print("Start: " + start + "	End: " + end + "\n");
//		System.out.print("-----------------------------------------------------------------\n");
		int val = array[pivot];
		int startIndex = start;
		int endIndex = end - 1;
		while(startIndex <= endIndex && startIndex < array.length && endIndex > 0)
		{	
			while(!(array[startIndex] >= val))
				startIndex++;
			while(!(array[endIndex] <= val))
				endIndex--;
		
			if(startIndex <= endIndex)
			{
				int temp = array[startIndex];
				array[startIndex] = array[endIndex];
				array[endIndex] = temp;
				
				endIndex--;
				startIndex++;
			}
		}
		
		if(startIndex == start)
			return;
		
//		printArray(array);
//		System.out.print("Start: " + start + "	End: " + end + "\n");
//		System.out.print("\n");
		
		doQuickSort(array, (startIndex + start)/2, start, startIndex);
		doQuickSort(array, (end + startIndex)/2, startIndex, end);
		return;
	}
	
	public void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
		System.out.println();
	}
}

