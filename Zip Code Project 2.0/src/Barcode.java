/**
 * Barcode Class
 * @author Matthew Spofford
 *
 * Used to convert between bar code data and zip code data
 * Focuses on storing related bar code information
 */
public class Barcode {

	private String[] barCode = new String[8];	//Stores each segment of a bar code
	private String errorValue = "";				//Stores the error code information
	
	private final String BARCODE_INVALID_ERR = "ERROR: Invalid Barcode";
	private final String ZIPCODE_INVALID_ERR = "ERROR: Invalid Checksum";
	private final String[] BARCODE_DIGITS = {"||:::",
		  		 					 		 ":::||",
				  		 					 "::|:|",
									  		 "::||:",
									  		 ":|::|",
									  		 ":|:|:",
									  		 ":||::",
									  		 "|:::|",
									  		 "|::|:",
									  		 "|:|::"};
	/**
	 * Can receive a bar code to store and convert to a zip code
	 * @param data - contains the bar code data in a string format
	 */
	public Barcode(String data)
	{
		barcodeConstructHelper(data);	//Calls the helper method
	}
	
	/**
	 * Bar code constructor helper method
	 * @param data - Is the bar code data in the string format
	 */
	private void barcodeConstructHelper(String data)
	{	
		int[] zipCodeArray = new int[6];	//Stores the digits of the zip code
		
		//Set header and footer in bar code, remove header and footer from data received
		barCode[0] = "|";
		data = data.substring(1);
		
		barCode[7] = "|";
		data = data.substring(0, data.length() - 1);
		
		//Loop through received bar code to store and convert
		for(int i = 0; i < 6; i++)
		{
			//Store bar code segment of data received
			String temp = data.substring(0, 5);
			if(data.length() >= 5)
				data = data.substring(5);	//Truncate bar code segment from data received
			
			barCode[i+1] = temp;	//Store bar code segment
			
			int digit = barValue(temp);	//Convert bar segment to numerical value
							
			if(digit == -1)		//If the value is invalid, output error value
			{
				errorValue = BARCODE_INVALID_ERR;
			}
			else
				zipCodeArray[i] = digit;
		}
		
		//If bar code is not invalid, set error code as invalid checksum
		if(!isValidChecksum(zipCodeArray) && !errorValue.equals(BARCODE_INVALID_ERR))
			errorValue = ZIPCODE_INVALID_ERR;			
	}
	
	/**
	 * Can receive zip code information to convert to a bar code
	 * Can also receive bar code information to be sent to the 
	 * @param data - Is the zip code or bar code data in string format
	 * @param isZipCode - Lets the constructor know that I zipCode is being sent
	 */
	public Barcode(String data, boolean isZipCode)
	{	
		if(!isZipCode)
			barcodeConstructHelper(data);
		else
		{
			//Outputs an error message if the zip code length is invalid
			if(data.length() > 5)
			{
				System.err.println("ERROR: Invalid zip code length");
				System.exit(-1);
			}
			
			int[] zipCodeArray = new int[6];	//Stores the digits of the zip code
			
			for(int i = 0; i < 5; i++)		//Stores zip code in in array format
				zipCodeArray[i] = Character.getNumericValue(data.charAt(i));
			
			int sum = 0;					//Calculate zip code sum to get checksum number
			for(int i = 0; i < 5; i++)
				sum += zipCodeArray[i];
			
			int greatestMultiple = 10;		//Find checksum digit
			while(greatestMultiple < sum)
				greatestMultiple += 10;
			
			zipCodeArray[5] = greatestMultiple - sum;	//Store checksum digit
			
			zipToBarCode(zipCodeArray);
		}
	}
	
	/**
	 * Converts the stored zip code to a bar code
	 */
	private void zipToBarCode(int[] zipCodeArray)
	{
		barCode[0] = "|";
		barCode[7] = "|";
		
		//Converts the corresponding digit of the zip code to a bar code value
		for(int i = 0; i < barCode.length - 2; i++)
			barCode[i + 1] = BARCODE_DIGITS[zipCodeArray[i]];
	}
	
	/**
	 * Outputs the correct numerical value of a bar code segment, outputs -1 if invalid
	 * @param bar - Segment of bar code being checked (Assumed to be 5 characters long)
	 * @return Outputs the numerical value of the bar code segment, -1 if invalid
	 */
	private int barValue(String bar)
	{
		//Checks bar segment by finding the matching numerical value 
		for(int i = 0; i < BARCODE_DIGITS.length; i++)
		{
			if(bar.equals(BARCODE_DIGITS[i]))
				return i;
		}
		
		return -1;
	}
	
	/**
	 * Outputs if the zip code values collected have a valid checksum, and if the bar code itself was valid
	 * @param zipCodeArray - Is an array integers of the zip code being checked, will not be changed in this method
	 * @return true if zip code values have a valid checksum, and if bar code is valid
	 */
	private boolean isValidChecksum(int[] zipCodeArray)
	{
		/*
		Checks to see if the checksum is a multiple of 10, 
		and if the zip code has not yet been set to an error code
		*/
		if(((zipCodeArray[0] + zipCodeArray[1] +
			 zipCodeArray[2] + zipCodeArray[3] +
			 zipCodeArray[4] + zipCodeArray[5]) % 10 == 0) && !errorValue.equals(BARCODE_INVALID_ERR))
			return true;
		else
			return false;
	}
	
	/**
	 * Outputs the checksum number of the bar code, and -1 if invalid
	 * @return returns the integer value of the bar code check sum, and -1 if invalid
	 */
	public int getChecksumNum()
	{
		int checkNum = -1;				//Stores the checksum digit
		String bar = barCode[6];	//Stores the segment of the bar code representing the checksum digit
		
		//Loops through numerical bar code representations to find matching number
		for(int i = 0; i < BARCODE_DIGITS.length; i++)
		{
			if(BARCODE_DIGITS[i].equals(bar))
			{
				checkNum = i;
				break;
			}
		}
		
		return checkNum;
	}
	
	/**
	 * Outputs the zip code value as a string, or error value
	 * @return Outputs string representation of zip code, or error value if needed
	 */
	public String getZipCode()
	{
		//If the error value has been set, output the error instead
		if(errorValue.equals(BARCODE_INVALID_ERR) || errorValue.equals(ZIPCODE_INVALID_ERR))
			return errorValue;
		
		String zipCode = "";	//Stores the zip code as a String
		
		//Loops through numerical bar code representations to find matching number of each bar code segment
		for(int i = 1; i < barCode.length - 2; i++)
		{
			for(int j = 0; j < BARCODE_DIGITS.length; j++)
			{
				if(barCode[i].equals(BARCODE_DIGITS[j]))
				{
					zipCode += j;
					break;
				}
			}
		}
		
		return zipCode;
	}
	
	/**
	 * Outputs the printable version of the bar code, adding no spaces between segments
	 * @return String representation of bar code with no spaces between segments
	 */
	public String getBarCodePrintable()
	{
		String output = "";
		//Loops through the array of bar code segments, concatenating them to the output strings 
		for(int i = 0; i < barCode.length; i++)
		{
			output += barCode[i] + "";
		}
		return output;
	}
	
	/**
	 * Outputs the readable version of the bar code, adding spaces between segments
	 * @return String representation of bar code with spaces between segments
	 */
	public String getBarCodeReadable()
	{
		String output = "";
		//Loops through the array of bar code segments adding spaces, concatenating them to the output strings
		for(int i = 0; i < barCode.length - 1; i++)
		{
			output += barCode[i] + "\t";
		}
		//Concatenates the ending bar code segment without a space at the end
		output += barCode[barCode.length - 1];
		return output;
	}
	
	/**
	 * Outputs the printable and readable version, with the zip code at the end
	 */
	public String toString()
	{
		return getBarCodePrintable() + "\n" + 
			   getBarCodeReadable() + " ----> " + getZipCode();
	}
}
