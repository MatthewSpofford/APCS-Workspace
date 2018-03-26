
/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 4;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			Long startTime = System.nanoTime();
			perfectShuffle(values1);
			Long endTime = System.nanoTime() - startTime;
			System.out.print(endTime + " ns");
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		
//		int[] array = {1, 2, 3, 4};
//		int[] copy = array.clone();
//		while(!(copy[0] == 4 && copy[1] == 3 && copy[2] == 2 && copy[3] == 1)) {
//			copy = array.clone();
//			selectionShuffle(copy);
//			System.out.println("\n\n");
//		}
//		System.out.println(copy[0] + "" + copy[1] + "" + copy[2] + "" + copy[3]);
		
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i+1;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] copy = new int[values.length];
		
		int k = 0;
		for(int i = 0; i < (values.length + 1)/2; i++) {
			copy[k] = values[i];
			k += 2;
		}
		k = 1;
		for(int i = (values.length + 1)/2; i < values.length; i++) {
			copy[k] = values[i];
			k += 2;
		}
		
		for(int i = 0; i < copy.length; i++) {
			values[i] = copy[i];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		//$ - 1234|
		//0 - 423|1
		//1 - 43|21
		//1 - 4|321
		//0 - |4321
		
		for(int i = values.length - 1; i >= 0; i--) {
			int newPos = (int) (Math.random() * (i + 1));
			int temp = values[newPos];
			values[newPos] = values[i];
			values[i] = temp;
		}
	}
}
