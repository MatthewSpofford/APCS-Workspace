

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("King", "Hearts", 10);
		Card card2 = new Card("5", "Clubs", 5);
		Card card3 = new Card("King", "Hearts", 10);
		
		System.out.println(card1 + "\n" + card2 + "\n" +card3);
		System.out.println(card1.matches(card3));
		System.out.println(card3.matches(card1));
		System.out.println(card1.matches(card2));
	}
}
