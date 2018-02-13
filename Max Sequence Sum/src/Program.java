import java.lang.reflect.Array;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		int[] array = { -4, 3, -1, 5, 6, -2, -9, 12, -3, 5, 7, -5, -1, 0, 1, -3 };
		
		//TODO Finish the Stav-method
		ArrayList<Module> arrayList = new ArrayList<Module>();
		
		for(int i = 0; i < array.length; i++)
		{
			Module temp = new Module(array[i], i, i);
			arrayList.add(temp);
		}
		
		ArrayList<Module> result = stavMethod(arrayList);
		for(int i = result.get(0).start; i <= result.get(0).end; i++)
		{
			System.out.print(array[i] + "  ");
		}
		
		
		//This works!!!
		int[] newArray = mattMethod(array);
		for(int i = 0; i < newArray.length; i++)
		{
			System.out.print(newArray[i] + "  ");
		}
	}

	public static ArrayList<Module> stavMethod(ArrayList<Module> array) {
		if(array.size() <= 1)
		{
			return array;
		}
		else
		{
			removeNegatives(array);
			
			
			
			return stavMethod(array);
		}
	}

	public static void combineModulues(ArrayList<Module> array)
	{
		
	}
	
	public static void removeNegatives(ArrayList<Module> array) {
		
		while(array.get(0).sum < 0 && array.size() >= 1)
			array.remove(0);
		while(array.get(array.size()-1).sum < 0 && array.size() >= 1)
			array.remove(array.size()-1);
	}
	
	
	public static int[] mattMethod(int[] array)
	{
		int startResult = 0;
		int endResult = 0;
		int sumResult = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			int sum = 0;
			for(int j = i; j < array.length; j++)
			{
				sum += array[j];
				if(sum > sumResult)
				{
					startResult = i;
					endResult = j;
					sumResult = sum;
				}
			}
		}
		
		int[] output = new int[endResult - startResult + 1];
		for(int i = 0; i < output.length; i++)
		{
			output[i] = array[i + startResult];
		}
		return output;
	}
}
