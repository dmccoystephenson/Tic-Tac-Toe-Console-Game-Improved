import java.util.Scanner;
public class GridTesting {

	public static void test() {
		Scanner scanner = new Scanner(System.in);
		StringGrid grid = new StringGrid(3, 3);
		
		grid.printGrid();
		System.out.println("Change something");
		String next = scanner.next();
		grid.alterSpace(next, "X");
		grid.printGrid();
	}
	
public static void main(String[] args) {
		//test();
		
	}

}
