import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * Client Class
 * @author SarahAkbar
 * This class runs the ZipCode project which converts zip codes to bar codes and vice versa. 
 * The output contains a zip code, the corresponding readable and printable barcodes,
 *  and the corresponding locations. 
 */
public class client {
	
	public static void main(String[] args) throws IOException  {
		//Reads the Zip Code file 
		File inFile = new File("ZipCodes.txt");
		Scanner in = new Scanner(inFile);
		// creates an array of zip code objects using the ZipCode class
		ZipCode[] zips = new ZipCode[10]; 
		for (int i = 0; i < zips.length && in.hasNextLine(); i ++) {
			String zip = in.nextLine(); 
			ZipCode code = new ZipCode(zip); 
			zips[i] = code; 
		}
		in.close();
		
		//prints the zip codes
		for(int i = 0; i < zips.length; i++)
		{
			System.out.println(zips[i]);
		}
		System.out.println("\n");
		
		//reads the ZipBarCodes file for the barcodes 
		File in2File = new File("ZipBarCodes.txt");
		Scanner in2 = new Scanner(in2File);
		
		//creates the barcode object array 
		Barcode[] bars = new Barcode[11]; 
		
		//creates a string array to output locations
		String[] locationOutput = new String[bars.length];
		
		//Creates an array of the barcodes to print
		for (int i = 0; i < bars.length && in2.hasNextLine(); i ++) {
			String zip = in2.nextLine(); 
			
			Barcode bar = new Barcode(zip); 
			ZipCode temp = new ZipCode(bar.getZipCode());
			locationOutput[i] = temp.getLocation();
			
			bars[i] = bar;
		}
		in2.close();
		
		//prints the barcodes and locations
		for(int i = 0; i < bars.length; i++)
		{
			System.out.println(bars[i]);
			System.out.println(locationOutput[i]);
		}
	}
}
