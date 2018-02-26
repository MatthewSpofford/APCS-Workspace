
public class Client {

	public static void main(String[] args) {
		
		int[] test = arrayInit(-20, 20);
		printArray(test);
	}
	
	public static int[] arrayInit(int startRange, int endRange)
	{
		int size = endRange - startRange + 1;
		int[] array = new int[size];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = startRange+i;
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
}
