import java.util.List;

public abstract class Board {

	private final int boardSize;
	
	private final String[] ranks;
	
	private final String[] suits;
	
	private final int[] pointValues;
	
	private Deck deck;
	
	private Card[] cardsDrawn;
	
	public Board(int boardSize, String[] ranks, String[] suits, int[] pointValues) {
		
		this.deck = new Deck(ranks, suits, pointValues);
		
		this.boardSize = boardSize;
		this.ranks = ranks;
		this.suits = suits;
		this.pointValues = pointValues;
	}

	public void deal()
	{
		for(int i = 0; i < cardsDrawn.length && !deck.isEmpty(); i++)
		{
			if(cardsDrawn[i] == null) {
				cardsDrawn[i] = deck.deal();
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
