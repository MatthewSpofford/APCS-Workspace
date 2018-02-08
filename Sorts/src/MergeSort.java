import java.util.Arrays;

public class MergeSort implements Sorts{

	public void sort(int[] array)
	{
		doMergeSort(array, 0, array.length);
	}
	
	private void doMergeSort(int[] array, int start, int end)
	{
		if(end - start <= 1)
		{
			return;
		}
		else
		{
			int aStart = start;
			int aEnd = (end + start)/2;
			int bStart = (end + start)/2;
			int bEnd = end;
			doMergeSort(array, aStart, aEnd);
			doMergeSort(array, bStart, bEnd);
			merge(array, aStart, aEnd, bStart, bEnd);
			return;
		}
	}
	
	private void merge(int[] array, int aStart, int aEnd, int bStart, int bEnd)
	{
		int[] output = new int[(aEnd - aStart) + (bEnd - bStart)];
		int aIndex = aStart;
		int bIndex = bStart;
		int index = 0;
		while(index < output.length)
		{
			if(aIndex >= aEnd)
			{
				for(int i = bIndex; i < bEnd; i++)
					output[index++] = array[i];
			}
			else if(bIndex >= bEnd)
			{
				for(int i = aIndex; i < aEnd; i++)
					output[index++] = array[i];
			}
			else
			{
				if(array[aIndex] < array[bIndex])
				{
					output[index++] = array[aIndex++];
				}
				else
				{
					output[index++] = array[bIndex++];
				}
			}
		}
		
		for(int i = 0; i < output.length; i++)
		{
			array[i + aStart] = output[i];
		}
	}
}
