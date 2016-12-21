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
		
		if ((move.substring(0,1).equalsIgnoreCase("A") || move.substring(0,1).equalsIgnoreCase("B") || move.substring(0,1).equalsIgnoreCase("C")) && (Integer.valueOf(move.substring(1,2)) == 1 || Integer.valueOf(move.substring(1,2)) == 2 || Integer.valueOf(move.substring(1,2)) == 3)) {
			if (grid.checkSpaceEmpty(move)) {
				grid.alterSpace(move, selection);
			}
			else {
				System.out.println("That space was taken! Try another!"); // problem with this is that it doesn't show the grid again...
				move();
			}
		}
		else {
			System.out.println("Input incompatible!");
			move();
		}
	}
}
