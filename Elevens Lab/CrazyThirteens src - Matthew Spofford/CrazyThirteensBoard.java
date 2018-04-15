import java.util.ArrayList;
import java.util.List;

/**
 * The CrazyThirteensBoard class represents the board in a game of Crazy Thirteens.
 * This game is based off of the game Thirteens, but adds some crazy rules.
 * 
 * <p>(1) If the pair selected contains a 6 and 7, then one of the cards in that
 * pair is randomly removed from the board. If it is the final 6 and 7 pair, 
 * then both of the cards will be removed.</p>
 * <p>(2) For removing the single king, the card will no longer be initially 
 * replaced.  If the board becomes empty but there are still kings in the deck,
 * then you lose.</p>
 */
public class CrazyThirteensBoard extends ThirteensBoard {
	
	/**
	 * Keeps track of how many sixes were removed
	 */
	private int sixRemovalCount = 0;
	/**
	 * Keeps track of how many sevens were removed
	 */
	private int sevenRemovalCount = 0;
	/**
	 * Keeps track of how many kings were removed
	 */
	private int kingRemovalCount = 0;
	/**
	 * Keeps track of what cards will be replaced that were previously removed
	 */
	private List<Integer> replacementList = new ArrayList<Integer>();
	/**
	 * Keeps track of what cards have been removed and need to be replaced
	 */
	private List<Integer> removalList = new ArrayList<Integer>();
	
	/**
	 * Creates a new <code>CrazyThirteensBoard</code> instance.
	 */
	public CrazyThirteensBoard() {
		super();
	}
	
	/**
	 * Start a new game by shuffling the deck and dealing some cards to this board. 
	 * It also resets all of counters and clears the removal lists.
	 */
	@Override
	public void newGame() {
		super.newGame();
		sixRemovalCount = 0;
		sevenRemovalCount = 0;
		kingRemovalCount = 0;
		replacementList.clear();
		removalList.clear();
	}
	
	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, the legal groups are: 
	 * <p>(1) a pair of non-face cards whose values add to 13.
	 * If the pair selected contains a face card, put the other card back into the deck.</p> 
	 * <p>(1-a) if there are enough six and seven pairs to continue playing
	 * <p>(2) a single card consisting of a king.</p>
	 * <p>(2-a) the board is not empty with kings in the deck.</p>
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		return super.anotherPlayIsPossible() && hasSixSevenPairs() && !emptyWithKingsInDeck();
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
	 * Outputs if the board is empty and there are still kings 
	 * left in the deck to be removed.
	 * @return 	True if the board is empty but there are kings left to be removed.
	 * 			False if emptying the deck is now impossible.
	 */
	private boolean emptyWithKingsInDeck() {
		return super.isEmpty() && kingRemovalCount < 4;
	}
	
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are: 
	 * <p>(1) a pair of non-face cards whose values add to 13.
	 * If the pair selected contains a face card, put the other card back into the deck.</p> 
	 * <p>(1-a) if the pair selected contains a 6 and 7, then one of the cards is randomly 
	 * kept. Both cards in the final 6 and 7 pair will be removed. This adds a slight 
	 * challenge because if you run out of 6s or 7s before creating all of the needed pairs, 
	 * then you lose the game.</p>
	 * <p>(2) a single card consisting of a king.  This card will not be initially replaced.</p>
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if(super.isLegal(selectedCards))
		{
			//Processes the six-seven pair and the single king
			processSixSevenPair(selectedCards);
			processSingleKing(selectedCards);
			//Adds the previously removed cards into the selected list
			selectRemovedCards(selectedCards);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Adds the previously removed cards to the selection list 
	 * in order to be replaced. This method also empties the
	 * list of previously removed cards and fills it with the
	 * next set of cards that need to be replaced.
	 */
	private void selectRemovedCards(List<Integer> selectedCards) {
		//Adds the removed cards into the selected list
		for(Integer val : replacementList) {
			selectedCards.add(val);
		}
		replacementList.clear();
		
		//Fills the replacement list with the next set of removed cards
		for(Integer val : removalList) {
			replacementList.add(val);
		}
		removalList.clear();
	}
	
	/**
	 * If the selected cards contain a six-seven pair, remove one
	 * of the cards from the board, and keep the other.
	 * @param selectedCards stores the selected card's positions
	 */
	private void processSixSevenPair(List<Integer> selectedCards) {
		//This begins the check for the six and seven pair.
		//Checks to see if this is the final six and seven pair
		//so that the game can continue.
		if(selectedCards.size() == 2 && 
		!(sixRemovalCount == 3 && sevenRemovalCount == 3)) {
			Card card1 = super.cardAt(selectedCards.get(0));
			Card card2 = super.cardAt(selectedCards.get(1));
			
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
	}
	
	/**
	 * If the selected cards contain a single king, remove the king
	 * from the board, and set it to be replaced after the next round.
	 * @param selectedCards stores the selected card's positions	 
	 */
	private void processSingleKing(List<Integer> selectedCards) {
		if(selectedCards.size() == 1) {
			Card card = super.cardAt(selectedCards.get(0));
			if(card.rank().equals("king")) {
				//Removes the card from the selected list so that it is not replaced
				Integer cardPos = selectedCards.get(0);
				selectedCards.remove(0);
				
				//Adds the card to the removal list so that it is replaced later
				removalList.add(cardPos);
				//Removes the card from the board
				super.removeCardFromBoard(cardPos.intValue());
				kingRemovalCount++;
			}
		}
	}
}
