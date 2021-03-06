import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;

public class Program {
	
	private static final double[] base = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static double[][] array = new double[362880][9];
	
	public static void main(String[] args) {
		
		int currentRowIndex = 0;
		int result = -1;
		
		while(currentRowIndex < array.length) {
			initArray(currentRowIndex);
			
			System.out.println(	currentRowIndex + "\tA: " + array[currentRowIndex][0] + ", " +
								"B: " + array[currentRowIndex][1] + ", " +
								"C: " + array[currentRowIndex][2] + ", " +
								"D: " + array[currentRowIndex][3] + ", " +
								"E: " + array[currentRowIndex][4] + ", " +
								"F: " + array[currentRowIndex][5] + ", " +
								"G: " + array[currentRowIndex][6] + ", " +
								"H: " + array[currentRowIndex][7] + ", " +
								"I: " + array[currentRowIndex][8] + " " );
			
			if(followsEquation(currentRowIndex)) {
				result = currentRowIndex;
				break;
			}
			
			currentRowIndex++;
		}
		
		System.out.println("\nANSWER:\n");
		
		System.out.println(	result + "\tA: " + array[result][0] + ", " +
												"B: " + array[result][1] + ", " +
												"C: " + array[result][2] + ", " +
												"D: " + array[result][3] + ", " +
												"E: " + array[result][4] + ", " +
												"F: " + array[result][5] + ", " +
												"G: " + array[result][6] + ", " +
												"H: " + array[result][7] + ", " +
												"I: " + array[result][8] + " " );

	}
	
	private static void initArray(int row) {
		
		boolean unique = false;
		
		while(!unique) {
			
			for(int i = 0; i < array[row].length; i++) {
				array[row][i] = base[i];
			}
			
			for(int i = array[row].length - 1; i >= 0; i--) {
				int newPos = (int) (Math.random() * (i + 1));
				double temp = array[row][newPos];
				array[row][newPos] = array[row][i];
				array[row][i] = temp;
			}
			
			double[] reference = array[row];
			unique = true;
			for(int i = 0; i < row; i++) {
				double[] prevArrayRef = array[i];
				if(Arrays.equals(reference, prevArrayRef)) {
					unique = false;
					break;
				}
				else {
					unique = true;
				}
			}
		}
	}
	
	private static boolean followsEquation(int row) {
		double ade = (array[row][0] / (array[row][3] * 10 + array[row][4]));
		double bfg = (array[row][1] / (array[row][5] * 10 + array[row][6]));
		double chi = (array[row][2] / (array[row][7] * 10 + array[row][7]));
		BigDecimal result = new BigDecimal(ade).add(new BigDecimal(bfg).add(new BigDecimal(chi)));
		
		System.out.println("\t " 	+ (int)array[row][0] + "/" + (int)array[row][3] + (int)array[row][4] + " + "
									+ (int)array[row][1] + "/" + (int)array[row][5] + (int)array[row][6] + " + "
									+ (int)array[row][2] + "/" + (int)array[row][7] + (int)array[row][8] + " = " + result);
		System.out.println("\t " 	+ ade + " + " + bfg + " + " + chi + " = " + result); 
		
		if(result.equals(new BigDecimal(1.0)))
			return true;
		else
			return false;
	}
}
