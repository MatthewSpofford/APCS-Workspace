import java.lang.reflect.Array;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		int[] array = { -4, 3, -1, 5, 6, -2, -9, 12, -3, 5, 7, -5, -1, 0, 1, -3 };
		
		ArrayList<Module> arrayList = new ArrayList<Module>();
		
		for(int i = 0; i < array.length; i++)
		{
			Module temp = new Module(array[i], i, i);
			arrayList.add(temp);
		}
		
		ArrayList<Module> result = stavMethod(arrayList);
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
}
