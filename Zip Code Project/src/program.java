import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Zip Code Program : By Matthew Spofford
 * Reads files of zipcodes to convert to barcodes,
 * as well as print city information
 * Also reads files of barcodes to be converted to zipcodes
 */

public class program {	
	
	//Stores all possible number representations in a bar code
	final static String[] BARCODE = {"||:::",
			  				  		 ":::||",
			  				  		 "::|:|",
			  				  		 "::||:",
			  				  		 ":|::|",
			  				  		 ":|:|:",
			  				  		 ":||::",
			  				  		 "|:::|",
			  				  		 "|::|:",
			  				  		 "|:|::"};
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//Create the files and inputs to be read from and interpreted
		File file1 = new File("ZipCodes.txt");
		Scanner inOpt1 = new Scanner(file1);
		File file2 = new File("ZipCodesCity.txt");
		Scanner inOpt2 = new Scanner(file2);
		File file3 = new File("ZipBarCodes.txt");
		Scanner inOpt3 = new Scanner(file3);
		
		//Start code for option 1
		while(inOpt1.hasNextLine())
		{
			String line = inOpt1.nextLine();
			if(line.isEmpty())
				continue;
			
			String[] parsedLine = parseLine(line);	//Parse line into zip code string, and city string (in this case nothing)
			String[] currBarCode = getBarCode(parsedLine[0]);	//Stores each segment of the bar code
			
			System.out.print(parsedLine[0]);	//Prints zipcode
			printBarCode(currBarCode);
		}
		inOpt1.close();
		
		String prevZipCode = "";
		String prevCity = "";
		String[] prevBarCode = new String[0];
		
		while(inOpt2.hasNextLine())
		{
			String line = inOpt2.nextLine();
			if(line.isEmpty())
				continue;
			
			String[] parsedLine = parseLine(line);	//Parse line into zip code string, and city string
			String[] currBarCode = getBarCode(parsedLine[0]);	//Stores each segment of the bar code
			
			if(prevZipCode.equals(parsedLine[0]))	//If previous zip code is equal to current zip code
			{
				if(prevCity.equals(parsedLine[1]))	//If the current city is equal to the last, skip to next line
					continue;
				printCityData(parsedLine[1], true);	//Print city data with a repeated zip code
			}
			else
			{
				if(prevBarCode.length != 0)	//If the previous bar code as been created, print it
					printBarCode(prevBarCode);
			    System.out.print(parsedLine[0] + "\t");	//Print zip code
			    printCityData(parsedLine[1], false);	//Print city data
			}
			prevZipCode = parsedLine[0];
			prevCity = parsedLine[1];
			prevBarCode = currBarCode;
		}
		printBarCode(prevBarCode);	//Print previous bar code that was not printed
		inOpt2.close();
		
		while(inOpt3.hasNextLine())
		{
			String line = inOpt3.nextLine();
			if(line.isEmpty())
				continue;
			
			String zipCode = parseBarCode(line);	//Parse line into a zip code or error string
			
			System.out.print(line + " ---->  " + zipCode + "\n");	//Print zip code or error string
			
			if(zipCode.contains("ERROR"))	//If there is an error, print no location
				System.out.print("No Location Found\n");
			else
			{
				inOpt2 = new Scanner(file2);	//Go to top of "ZipCodesCity.txt"
				
				boolean prevIsCurrZip = false;	//Is true if the last read line contained the current zip code
				
				while(inOpt2.hasNextLine())
				{
					String lineCity = inOpt2.nextLine();
					String[] parsedLine = parseLine(lineCity);	//Parse line into zip code string, and city string
					if(parsedLine[0].equals(zipCode))	//If the current line contains the zip code found
					{
						System.out.print(parsedLine[1] + "\n");	//Print city data
						prevIsCurrZip = true;
					}
					else
					{
						if(prevIsCurrZip)	//Break loop since the zip code's cities have been found
							break;
					}
				}
			}
		}
		inOpt3.close();
	}
	
	/**
	 * Parses the current line to find a zip code and city information
	 * @param line should contains a zip code and/or city information
	 * @return Separates the zip code from city info in string format, zip code in index 0, city in index 1
	 */
	static String[] parseLine(String line)
	{
		String[] output = new String[2];	//Output will contain zip code in index 0, city in index 1
		
		int zipCodeEnd = 0;	//Is the index value of the end of the zip code
		
		for(int i = 0; i < line.length(); i++)
		{
			if(Character.isDigit(line.charAt(i)) == false)	//If the line no longer contains a number, whole zip code has been found
				break;
				
			zipCodeEnd = i;
		}
		
		output[0] = line.substring(0, zipCodeEnd+1);	//Store zip code
		
		if(output[0].length() == line.length())	//If there is nothing left on the line, return the zip code string
		{
			return output;
		}
		
		output[1] = line.substring(zipCodeEnd + 1, line.length());	//Store city data
		char[] cityInfo = output[1].toCharArray();	//Store city data as char array
		
		for(int i = 0; i < cityInfo.length; i++)	//Loop through city data and remove ","
		{
		    if(cityInfo[i] == ',')
		        cityInfo[i] = ' ';
		}
		
		output[1] = String.valueOf(cityInfo);	//Convert city data char array back into string 
		output[1] = output[1].trim();	//Trim spaces off of city data
		
		return output;
	}
	
	/**
	 * Prints the bar code in readable and printable format
	 * @param barCode Segments of the bar code to be printed
	 */
	static void printBarCode(String[] barCode)
	{
		String output = "\t\t\tReadable Barcode: ";
		
		for(int i = 0; i < barCode.length; i++)
		{
			output += barCode[i] + "   ";
		}
		output += "\n";
		
		output += "\t\t\tPostal BarCode: ";
		
		for(int i = 0; i < barCode.length; i++)
		{
			output += barCode[i];
		}
		output += "\n";
		
		System.out.print(output);
	}
	
	/**
	 * Prints the city information
	 * @param city Contains the city information
	 * @param repeat Adds an extra tab to the output if repeat is true
	 */
	static void printCityData(String city, boolean repeat)
	{
		if(repeat)
			System.out.printf("\t\t\t%s\n", city);
		else
			System.out.printf("\t\t%s\n", city);
	}
	
	/**
	 * Gets the bar code of a given zip code value
	 * @param zipCode is the five-digit zip code as a string
	 * @return Outputs all segments of bar code in a string format
	 */
	static String[] getBarCode(String zipCode)
	{
		String[] output = new String[8];	//Create a string array to store bar code
		for(int i = 0; i < output.length; i++)	//Set all portions of bar code to null
			output[i] = "";
		
		int[] digits = new int[5];	//Is an array meant to store all digits of zip code
		int sum = 0;	//Stores checksum of all digits in zip code
		
		for(int i = 0; i < digits.length || i < zipCode.length(); i++)
		{	
			digits[i] = Character.getNumericValue(zipCode.charAt(i));	//Get numerical value of each digit in zip code
			sum += digits[i];
		}
		
		output[0] = "|";	//Adds header string to bar code
		output[output.length - 1] = "|";	//Adds footer string to bar code
		for(int i = 0; i < digits.length; i++)
		{
			output[i + 1] = BARCODE[digits[i]];	//Converts digits of zip code into bar code format and store in output
		}
		
		int lowMultipleTen = 0;	//Stores lowest multiple of ten that is closest to sum of all digits in zip code
		while(sum > lowMultipleTen)
		{
			lowMultipleTen += 10;
		}
		
		int newDigit = lowMultipleTen - sum;	//Finds checksum by subtracting the lowest multiple of ten by current sum
		output[output.length - 2] = BARCODE[newDigit];	//Store new digit in bar code format
		
		return output;
	}
	
	/**
	 * Parses a bar code and converts it to a zip code if valid
	 * @param line contains the line of barcode to be converted to a zipcode
	 * @return output of the zip code as a string
	 */
	 static String parseBarCode(String line)
	 {
	     String output = "";	//Stores zip code as string
	     char[] lineChar = line.toCharArray();	//Converts bar code to char array
	     char[] temp = new char[line.length() - 2];	//Stores temp of char array, but smaller to remove header and footer string 
	     
	     for(int i = 0; i < temp.length; i++)
	     {
	         temp[i] = lineChar[i+1];	//Store bar code char array without header and footer string
	     }
	     line = String.valueOf(temp);	//Store new bar code as string
	     
	     int[] digits = new int[6];	//Stores the digits in the bar code
	     int digitIndex = 0;	//Stores the current index of the bar code digits array
	     for(int i = 0; i < digits.length; i++)
	     {
	    	 digits[i] = -999;	//Sets digits of bar code to error value
	     }	     
	     
	     for(int i = 0; i < line.length() - 4 && digitIndex < digits.length; i += 5)
	     {
	    	 if(digitIndex - 1 >= 0 && digits[digitIndex - 1] == -999)	//If no previous digit was found, return invalid bar code
    		 {
    			 return "ERROR - Invalid barcode";
    		 }
	    	 String tempString = line.substring(i, i + 5);	//Get current segment of bar code to be converted to numerical value
	    	 for(int j = 0; j < BARCODE.length; j++)
	    	 {
	    		 if(tempString.equals(BARCODE[j]))	//If current segment of bar is equal to an actual bar code value, stores its numerical value
	    		 {
	    			 digits[digitIndex] = j;
	    			 break;
	    		 }
	    	 }
	    	 digitIndex += 1;
	     }
	     
	     int sum = 0;	//Stores checksum of digits
	     for(int i = 0; i < digits.length; i++)
	     {
	    	 sum += digits[i];	//Add digits found to get sum
	     }
	     
	     if(sum % 10 == 0)	//If checksum is valid, convert digits to string to be output
	     {
	    	 for(int i = 0; i < digits.length - 1; i++)
	    	 {
	    		 output += digits[i];
	    	 }
	     }
	     else
	    	 output = "ERROR - Invalid checksum";	//Output invalid checksum
	     
	     return output;	//Return zip code
	 }
}
