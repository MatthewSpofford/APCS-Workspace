/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8"};
		String[] suits = {"Red", "Yellow", "Blue"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
		Deck deck1 = new Deck(ranks, suits, values);
		
		while(deck1.size() > 4)
			deck1.deal();
		
		System.out.println(deck1);
	}
}
