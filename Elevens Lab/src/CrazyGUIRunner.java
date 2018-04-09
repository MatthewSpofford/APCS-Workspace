/**
 * This is a class that plays the GUI version of the Crazy Thirteens game.
 * See accompanying documents for a description of how Crazy Thirteens is played.
 */
public class CrazyGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new CrazyThirteensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
