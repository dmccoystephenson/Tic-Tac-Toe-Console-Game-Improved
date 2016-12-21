import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class TicTacToe {
	static Scanner scanner = new Scanner(System.in);
	
	static StringGrid grid;
	
	public TicTacToe(StringGrid g) {
		grid = g;
	}
	
	public static String checkIfWon() {
		for (int r = 0; r < 3; r++) { //checks rows
			if (grid.grid[r][0].equals(" [X] ") && grid.grid[r][1].equals(" [X] ") && grid.grid[r][2].equals(" [X] ")) {
				return "X";
			}
			if (grid.grid[r][0].equals(" [O] ") && grid.grid[r][1].equals(" [O] ") && grid.grid[r][2].equals(" [O] ")) {
				return "O";
			}
		}
		for (int c = 0; c < 3; c++) { //checks columns
			if (grid.grid[0][c].equals(" [X] ") && grid.grid[1][c].equals(" [X] ") && grid.grid[2][c].equals(" [X] ")) {
				return "X";
			}
			if (grid.grid[0][c].equals(" [O] ") && grid.grid[1][c].equals(" [O] ") && grid.grid[2][c].equals(" [O] ")) {
				return "O";
			}
		}
		if (grid.grid[0][0].equals(" [X] ") && grid.grid[1][1].equals(" [X] ") && grid.grid[2][2].equals(" [X] ")) { //checks diagonal
			return "X";
		}
		if (grid.grid[0][0].equals(" [O] ") && grid.grid[1][1].equals(" [O] ") && grid.grid[2][2].equals(" [O] ")) { //checks diagonal
			return "O";
		}
		if (grid.grid[0][2].equals(" [X] ") && grid.grid[1][1].equals(" [X] ") && grid.grid[2][0].equals(" [X] ")) { //checks diagonal
			return "X";
		}
		if (grid.grid[0][2].equals(" [O] ") && grid.grid[1][1].equals(" [O] ") && grid.grid[2][0].equals(" [O] ")) { //checks diagonal
			return "O";
		}
		return " [ ] ";
	}
	
	public static void selectMode() {
		System.out.println("\nWhich mode would you like to play?");
		System.out.println("[1] Player VS Player");
		System.out.println("[2] Player VS BadAI");
		System.out.println("[3] Player VS GoodAI");
		System.out.println("\nAI ONLY:");
		System.out.println("[4] BadAI VS BadAI");
		System.out.println("[5] BadAI VS GoodAI");
		System.out.println("[6] GoodAI VS GoodAI");
		
		String mode = scanner.next();
		
		switch(mode) {
		case "1":
			PVP();
			break;
		case "2":
			PVB();
			break;
		case "3":
			PVG();
			break;
		case "4":
			BVB();
			break;
		case "5":
			BVG();
			break;
		case "6":
			GVG();
			break; 
		default:
			System.out.println("Not an option!");
			selectMode();
			break;
		}
	}
	
	public static void PVP() {
		while (true) {
			Player player1 = new Player(grid, "X");
			grid.printGrid();
			player1.move();
			
			if (checkIfWon().equals("X")) {
				grid.printGrid();
				System.out.println("Player 1 Wins!");
				break;
			}
			
			if (checkIfWon().equals("O")) {
				grid.printGrid();
				System.out.println("Player 2 Wins!");
				break;
			}
			
			if (grid.checkFull()) {
				grid.printGrid();
				System.out.println("It's a tie!");
				break;
			}
			
			Player player2 = new Player(grid, "O");
			grid.printGrid();
			player2.move();
			
			if (checkIfWon().equals("X")) {
				grid.printGrid();
				System.out.println("Player 1 Wins!");
				break;
			}
			
			if (checkIfWon().equals("O")) {
				grid.printGrid();
				System.out.println("Player 2 Wins!");
				break;
			}
		}
	}
	
	public static void PVB() {
		while (true) {
			Player human = new Player(grid, "X");
			grid.printGrid();
			human.move();
			grid.printGrid();
			
			if (checkIfWon().equals("X")) {
				grid.printGrid();
				System.out.println("You win!");
				break;
			}
			
			if (checkIfWon().equals("O")) {
				grid.printGrid();
				System.out.println("You lose!");
				break;
			}
			
			if (grid.checkFull()) {
				grid.printGrid();
				System.out.println("It's a tie!");
				break;
			}
			
			RandomAI opponent = new RandomAI(grid, "O");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			opponent.move();

			if (checkIfWon().equals("X")) {
				grid.printGrid();
				System.out.println("You win!");
				break;
			}
			
			if (checkIfWon().equals("O")) {
				grid.printGrid();
				System.out.println("You lose!");
				break;
			}
		}
	}
	
	public static void PVG() {
		System.out.println("Coming soon!");
		selectMode();		
	}
	
	public static void BVB() {

		while (true) {
			
			RandomAI contestant1 = new RandomAI(grid, "X");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			grid.printGrid();
			contestant1.move();
			
			if (checkIfWon().equals("X")) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				grid.printGrid();
				System.out.println("Contestant 1 wins!");
				break;
			}
			
			if (grid.checkFull()) {
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				grid.printGrid();
				System.out.println("It's a tie!");
				break;
			}
			
			RandomAI contestant2 = new RandomAI(grid, "O");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			grid.printGrid();
			contestant2.move();
						
			if (checkIfWon().equals("O")) {
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				grid.printGrid();
				System.out.println("Contestant 2 wins!");
				break;
			}
		}	
	}
	
	public static void BVG() {
		System.out.println("Coming soon!");
		selectMode();		
	}
	
	public static void GVG() {
		System.out.println("Coming soon!");
		selectMode();		
	}
}
