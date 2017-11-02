import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * ZipCode Class
 * @author SarahAkbar
 *This class converts a zip code into a bar code and prints the corresponding locations
 */

public class ZipCode {
	
	private String zipC;  //original zip code string from the zip code file
	String[] places; // string array of the places that correspond to the specific zip codes
	Location[] placeArray; //object array of the places that correspond to the specific zip codes

	/**
	 * Creates the ZipCode object using the findLocation and makeLocationArray methods
	 * @param zip taken from client class ----> String of the next line in the zipcode file
	 * @throws IOException
	 */
	public ZipCode(String zip) throws IOException {  
		zipC = zip; 
		placeArray = findLocation();
		this.places = makeLocationArray();
	}
	
	/**
	 * Creates a barcode object using the zip code read from the file
	 * @return the barcode object
	 */
	private Barcode getBarObj()
	{
		Barcode barCode = new Barcode(zipC, true);
		return barCode;
	}
	
	/**
	 * returns the printable barcode from the getBarObj method 
	 * @return
	 */
	public String getBarCode()
	{
		return getBarObj().getBarCodePrintable();
	}
	
	/**
	 * Creates an string of locations 
	 * @return
	 */
	public String getLocation()
	{
		String output = "";
		
		for (int i = 0; i < places.length ; i ++) {
			if (places[i].isEmpty())
				break; 
				
			output += places[i] + "\n"; 
		}
		
		return output;
	}
	/**
	 * Searches through the ZipCodesCity file for the corresponding locations 
	 * and creates an object array for location
	 * @return
	 * @throws IOException
	 */
	private Location[] findLocation() throws IOException {
		File in3File = new File("ZipCodesCity.txt");
		Scanner in3 = new Scanner(in3File);
		int count = 0; 
		Location place = new Location();
		Location[] placeArray= new Location[25];
		for(int i = 0; i < placeArray.length; i++)
			placeArray[i] = new Location();
		
		while (in3.hasNextLine()) {

			String entire = in3.nextLine();
			
			
			if (entire.substring(0, 5).equals(zipC)) {	
				String[] zip = new String [3];
				 
				zip = entire.split(",");	
				String city = zip[1]; 
				String state = zip[2];
				place = new Location(city, state); 
				
				placeArray[count] = place; 
				count++; 
			}
		}
		in3.close();
		
		return placeArray; 
	}
			
	
	/**
	 * Creates a string array version of the location array from the findLocation method
	 * @return
	 * @throws IOException
	 */
	public String[] makeLocationArray() throws IOException {
		places = new String[25]; 	
		for (int i = 0; i < placeArray.length; i++) {
			places[i] = placeArray[i].toString(); 
			places[i] = places[i].trim();
		}
		return places; 
	}
	/**
	 * Builds a string using the zipcode, barcode (readable and printable), and location
	 * @return
	 */
	private String buildString() {
		String a = ""; 
		String c = ""; 

		a = getLocation();
		
		Barcode bar = getBarObj();
		String b = bar.getBarCodePrintable() + "\n\t\t" + bar.getBarCodeReadable(); 
		c = zipC + " ---->\t" + b + "\n" + a; 
		return c; 
	}
	/**
	 * returns as a string 
	 */
	public String toString() {
		String x = buildString();
		return x; 
	}
	
}
