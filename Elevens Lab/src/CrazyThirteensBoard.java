import java.util.List;

public class CrazyThirteensBoard extends ThirteensBoard {
	
	
	/**
	 * Creates a new <code>CrazyThirteensBoard</code> instance.
	 */
	public CrazyThirteensBoard() {
		super();
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, the legal groups are: 
	 * <p>(1) a pair of non-face cards whose values add to 13.
	 * If the pair selected contains a face card, put the other card back into the deck.</p> 
	 * <p>(2) a single card consisting of a king.</p>
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		return super.anotherPlayIsPossible();
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are: 
	 * <p>(1) a pair of non-face cards whose values add to 13.
	 * If the pair selected contains a face card, put the other card back into the deck.</p> 	 
	 * <p>(2) a single card consisting of a king.</p>
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		return super.isLegal(selectedCards);
	}
}
