import java.util.Scanner;
public class Player {
	private static Scanner scanner = new Scanner(System.in);
	
	private static StringGrid grid;
	static String selection;
	
	public Player(StringGrid g, String s) {
		grid = g;
		selection = s;
	}
	
	public void move() {
		System.out.println("Make your move!");
		String move = scanner.next(); // handle input error!!!
		
		if (grid.checkSpaceEmpty(move)) {
			grid.alterSpace(move, selection);
		}
		else {
			System.out.println("That space was taken! Try another!"); // problem with this is that it doesn't show the grid again...
			move();
		}
	}
	
}
