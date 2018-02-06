
public class BubbleSort {

	public static void sort(int[] array)
	{
		boolean noSwap = false;
		while(!noSwap)
		{
			noSwap = true;
			for(int i = 0; i < array.length - 1; i++)
			{
				if(array[i] > array[i+1])
				{
					int temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					noSwap = false;
				}
			}
		}
	}
}
