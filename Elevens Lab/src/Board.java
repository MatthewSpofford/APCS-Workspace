import java.util.List;

public abstract class Board {

	private final int boardSize;
	
	private final String[] ranks;
	
	private final String[] suits;
	
	private final int[] pointValues;
	
	private Deck deck;
	
	private Card[] cards;
	
	public Board(int boardSize, String[] ranks, String[] suits, int[] pointValues) {
		
		this.deck = new Deck(ranks, suits, pointValues);
		
		this.boardSize = boardSize;
		this.ranks = ranks;
		this.suits = suits;
		this.pointValues = pointValues;
	}

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	public int size() {
		return cards.length;
	}

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
	public boolean isEmpty() {
		for (int k = 0; k < cards.length; k++) {
			if (cards[k] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param k the index of the card to be dealt.
	 */
	public void deal(int k) {
		cards[k] = deck.deal();
	}

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
	public int deckSize() {
		return deck.size();
	}

	/**
	 * Accesses a card on the board.
	 * @return the card at position k on the board.
	 * @param k is the board position of the card to return.
	 */
	public Card cardAt(int k) {
		return cards[k];
	}
	
	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
	public String toString() {
		String s = "";
		for (int k = 0; k < cards.length; k++) {
			s = s + k + ": " + cards[k] + "\n";
		}
		return s;
	}
	
	public void deal()
	{
		for(int i = 0; i < cards.length && !deck.isEmpty(); i++)
		{
			if(cards[i] == null) {
				cards[i] = deck.deal();
			}
		}
	}
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * 
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public abstract boolean isLegal(List<Integer> selectedCards);

	/**
	 * Determine if there are any legal plays left on the board.
	 * 
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public abstract boolean anotherPlayIsPossible();
}
