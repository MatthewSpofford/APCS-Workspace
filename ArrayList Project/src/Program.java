import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Program {

	public static void main(String[] args) {
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Train("Blue Train"));
		vehicles.add(new Plane("Boeing 747"));
		vehicles.add(new Train("Red Train"));
		vehicles.add(new Train("Yellow Train"));
		vehicles.add(new Plane("Some other plane"));
		
		ListIterator<Vehicle> iteratorList = vehicles.listIterator();
		while(iteratorList.hasNext())
		{
			iteratorList.next().move();
		}
		System.out.println("");
		System.out.println("");
		
		vehicles.add(2, new Plane("Some other plane"));
		for(int i = 0; i < vehicles.size(); i++)
			vehicles.get(i).move();
		System.out.println("");
		System.out.println("");
		
		vehicles.set(3, new Train("Red Train"));
		Iterator<Vehicle> iterator = vehicles.iterator();
		while(iterator.hasNext())
		{
			iterator.next().move();
		}
		System.out.println("");
		System.out.println("");
		
		vehicles.remove(1);
		vehicles.set(4, vehicles.get(1));	
		for(Vehicle vehicle : vehicles)
			vehicle.move();
		
	}

}
