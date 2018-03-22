
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
		
		System.out.println("\nANSWER:");
		
		
		System.out.println(result);
	}
	
	private static void initArray(int row) {
		
		boolean[] used = new boolean[base.length];
		boolean unique = false;
		double[][] reference = array;
		
		while(!unique) {
			
			for(int i = 0; i < array[row].length; i++) {
				int pos = (int) (Math.random() * 9);
				
				while(used[pos]) {
					pos = (int) (Math.random() * 9);
				}
				
				used[pos] = true;
				array[row][i] = base[pos];
			}
			
			unique = true;
			for(int i = 0; i < row; i++) {
				unique = false;
				for(int j = 0; j < array[row].length; j++) {
					if(array[row][j] != array[i][j]) {
						unique = true;
						break;
					}
				}
			}
			
			for(int i = 0; i < used.length; i++) {
				used[i] = false;
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
