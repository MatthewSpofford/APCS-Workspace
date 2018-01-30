import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class program {
	
	public static void main(String[] args)
	{
		ArrayList<String> array = new ArrayList<String>();
		ListIterator<String> iterator = array.listIterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}
	
	public static ArrayList<Integer> students = new ArrayList<Integer>();
	
	static public Integer getValedictorian()
	{
		Integer output;
		double highestGPA = 0;
		Iterator<Integer> iterator = students.iterator()
		
		while(iterator.hasNext())
		{
			Integer student = iterator.next();
			if(student.getGPA() > highestGPA)
			{
				output = student;
				highestGPA = student.getGPA();
			}
		}

		return output;
	}
	
	static public double getHonorsPercent()
	{
		int honorsCounter = 0;
		int totalCounter = 0;
		Iterator<Integer> iterator = students.iterator();
		
		while(iterator.hasNext())
		{
			Integer student = iterator.next();
			if(student.isHonors())
				honorsCounter += 1;
			
			totalCounter += 1;
		}
			
		return honorsCounter/totalCounter;
	}

}