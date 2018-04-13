
public class Test {

	public static void main(String[] args) {
//		int[] array = {4, 1, 10, 3, 6, 3, 6, 10, 9, 12, 5};
//		doSome(array, 5);
		
		mysteryMix("la-la-la!");
		//la-la-la!
		//la-	la-		la!
		//l -			l !
		//		ala-a
	}
	
	public static void doSome(int[] arr, int lim) {
		int v = 0;
		int k = 0;
		int t = 0;
		while (k < arr.length && arr[k] < lim) {
			if(arr[k] > v) {
				v = arr[k];
				t++;	//Statement T
			}
			k++;	//Statement S
		}
		
		System.out.println("V: " + v + "\nT: " + t + "\nS: " + k);
	}
	
	public static void mysteryMix(String str) {
		int len = str.length();
		if(len >= 3) {
			mysteryMix(str.substring(0, len/3));
			System.out.print(str.substring(len/3, 2*len/3));
			mysteryMix(str.substring(2*len/3));
		}
	}
}
