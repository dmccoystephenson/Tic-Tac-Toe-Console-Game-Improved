import java.util.Random;
public class RandomAI {
	private static Random random = new Random();
	
	private static StringGrid grid;
	private static String selection;
	
	public RandomAI(StringGrid g, String s) {
		grid = g;
		selection = s;
	}
	
	public void move() {
		String[] letters = {"A", "B", "C"};
		
		String move = (letters[random.nextInt(3)] + (random.nextInt(3) + 1));
		if (grid.checkSpaceEmpty(move)) {
			grid.alterSpace(move, selection);
		}
		else {
			move();
		}
	}
	
}
