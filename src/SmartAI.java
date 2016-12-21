
public class SmartAI {
	private static StringGrid grid;
	private static String selection;
	
	public SmartAI(StringGrid g, String s) {
		grid = g;
		selection = s;
	}
	
	public static void checkIfEnemyAboutToWin() {
		// checks if two of opposite move in a row, and if so, block them
	}
	
	public static boolean middleTaken() {
		// checks if middle position is taken
		
		return false; //change
	}
	
	public static void takeMiddle() {
		// takes middle position
	}
	
	public static boolean cornerTaken() {
		// do I need this?
		
		return false; //change
	}
	
	public static void takeCorner() {
		// take corner depending on which one is most viable option
	}
	
}
