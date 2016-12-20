
public class Driver {

	public static void main(String[] args) {

		StringGrid grid = new StringGrid(3, 3);
		
		TicTacToe game = new TicTacToe(grid);
		
		game.selectMode();
	}

}
