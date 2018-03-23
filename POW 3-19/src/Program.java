import java.lang.reflect.Array;
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
		double[][] reference = array;
		
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
			
			for(int i = 0; i < row; i++) {
				if(Arrays.equals(array[i], array[row])) {
					unique = true;
				}
				else {
					unique = false;
				}
			}
		}
	}
	
	private static boolean followsEquation(int row) {
		double result = 	(array[row][0] / (array[row][3] * 10 + array[row][4])) + 
							(array[row][1] / (array[row][5] * 10 + array[row][6])) + 
							(array[row][2] / (array[row][7] * 10 + array[row][7]));
		
		System.out.println("\t " + result);
		
		if(result == 1.0)
			return true;
		else
			return false;
	}
}
