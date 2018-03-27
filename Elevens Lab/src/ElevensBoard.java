import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if(containsJQK(selectedCards) || containsPairSum11(selectedCards)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		
		for(int i = 0; i < this.cardIndexes().size(); i++) {
			for(int j = 0; j < this.cardIndexes().size(); j++) {
				if(i == j && j + 1 < this.cardIndexes().size()) {
					j++;
				}
				
				List<Integer> cards = new ArrayList<Integer>();
				cards.add(cardIndexes().get(i));
				cards.add(cardIndexes().get(j));
				
				if(containsPairSum11(cards)) {
					return true;
				}
			}
		}
		
		for(int i = 0; i < this.cardIndexes().size(); i++) {
			for(int j = i + 1; j < this.cardIndexes().size(); j++) {
				for(int k = j + 1; k < this.cardIndexes().size(); k++) {
					List<Integer> cards = new ArrayList<Integer>();
					cards.add(this.cardIndexes().get(i));
					cards.add(this.cardIndexes().get(j));
					cards.add(this.cardIndexes().get(k));
					
					if(containsJQK(cards)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		
		if(selectedCards.size() == 2) {
			Card card1 = this.cardAt(selectedCards.get(0));
			Card card2 = this.cardAt(selectedCards.get(1));
			
			if(card1.pointValue() + card2.pointValue() == 11) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		
		final String JACK = RANKS[10];
		final String QUEEN = RANKS[11];
		final String KING = RANKS[12];
		
		if(selectedCards.size() == 3) {
			Card[] cards = new Card[3]; 
			cards[0] = this.cardAt(selectedCards.get(0));
			cards[1] = this.cardAt(selectedCards.get(1));
			cards[2] = this.cardAt(selectedCards.get(2));
			
			boolean foundJack = false;
			boolean foundQueen = false;
			boolean foundKing = false;
			
			for(int i = 0; i < cards.length; i++) {
				String rank = cards[i].rank();
				if(rank.equals(JACK)) {
					foundJack = true;
				}
				if (rank.equals(QUEEN)) {
					foundQueen = true;
				}
				if (rank.equals(KING)) {
					foundKing = true;
				}
			}
			
			if(foundJack && foundQueen && foundKing) {
				return true;
			}
		}
		
		return false;
	}
}
