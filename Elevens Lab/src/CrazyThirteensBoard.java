import java.util.List;

public class CrazyThirteensBoard extends ThirteensBoard {
	
	private int sixRemovalCount = 0;	//Keeps track of how many sixes were removed
	private int sevenRemovalCount = 0;	//Keeps track of how many sevens were removed
	
	/**
	 * Creates a new <code>CrazyThirteensBoard</code> instance.
	 */
	public CrazyThirteensBoard() {
		super();
	}
	
	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	@Override
	public void newGame() {
		super.newGame();
		sixRemovalCount = 0;
		sevenRemovalCount = 0;
	}
	
	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, the legal groups are: 
	 * <p>(1) a pair of non-face cards whose values add to 13.
	 * If the pair selected contains a face card, put the other card back into the deck.</p> 
	 * <p>(1-a) if there are enough six and seven pairs to continue playing
	 * <p>(2) a single card consisting of a king.</p>
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		return super.anotherPlayIsPossible() && hasSixSevenPairs();
	}
	
	/**
	 * Outputs if the user has run out of all the six or sevens, 
	 * preventing them from winning the game because they can 
	 * longer create enough pairs to clear the board.
	 * @return 	True if 6 and 7 pairs can still be made;
	 * 			False if 6 and 7 pairs are now impossible.
	 */
	private boolean hasSixSevenPairs() {
		return !(sixRemovalCount >= 4 || sevenRemovalCount >= 4);
	}
	
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are: 
	 * <p>(1) a pair of non-face cards whose values add to 13.
	 * If the pair selected contains a face card, put the other card back into the deck.</p> 
	 * <p>(1-a) if the pair selected contains a 6 and 7, and the board does not have 2 cards 
	 * remaining, then one of the cards is randomly kept. Both cards in the final 6 and 
	 * 7 pair will be removed.</p>
	 * <p>(2) a single card consisting of a king.</p>
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if(super.isLegal(selectedCards))
		{
			//This begins the check for the six and seven pair.
			//Checks to see if this is the final six and seven pair
			//so that the game can continue.
			if(selectedCards.size() == 2 && 
			!(sixRemovalCount == 3 && sevenRemovalCount == 3)) {
				Card card1 = this.cardAt(selectedCards.get(0));
				Card card2 = this.cardAt(selectedCards.get(1));
				
				//Checking if one card in the pair contains a 6
				//7 is implied, since isLegal would not succeed.
				if(card1.pointValue() == 6 || card2.pointValue() == 6) {
					
					//Randomly select a card to keep
					double cardRemovedPercent = Math.random();
					if(cardRemovedPercent > 0.5) {
						selectedCards.remove(0);
						if(card1.pointValue() == 6) {
							sixRemovalCount++;
						} else {
							sevenRemovalCount++;
						}
					} else {
						selectedCards.remove(1);
						if(card2.pointValue() == 6) {
							sixRemovalCount++;
						} else {
							sevenRemovalCount++;
						}
					}
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}
