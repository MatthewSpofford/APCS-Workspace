
public class Test {

	public static void main(String[] args) {
		int[] array = {4, 1, 10, 3, 6, 3, 6, 10, 9, 12, 5};
		doSome(array, 5);
	}
	
	public static void doSome(int[] arr, int lim) {
		int v = 0;
		int k = 0;
		int t = 0;
		while (k < arr.length && arr[k] < lim) {
			if(arr[k] > v) {
				v = arr[k];
				t++;
			}
			k++;
		}
		
		System.out.println("V: " + v + "\nT: " + t + "\nS: " + k);
	}
}
