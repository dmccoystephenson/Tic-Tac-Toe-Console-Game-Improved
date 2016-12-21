
public class StringGrid {

	public static String[][] grid;
	private static int rows;
	private static int columns;
	
	public StringGrid(int numRows, int numColumns) {
		rows = numRows;
		columns = numColumns;
		grid = new String[rows][columns];
		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				grid[r][c] = " [ ] ";
			}
		}
		
	}
	
	public void printGrid() {
		System.out.println("\n");
		for (int c = 0; c < grid[0].length; c++) {
			System.out.print("    " + ((char) (c + 65)));
		}
		
		System.out.println("\n");
		
		for (int r = 0; r < grid.length; r++) {
			System.out.print((r + 1) + " ");
			for (int c = 0; c < grid[0].length; c++) {
				System.out.print(grid[r][c]);
			}
			System.out.println("\n");
		}
	}
	
	public boolean checkSpaceEmpty(String xy) {
		int y = Integer.valueOf(xy.substring(1, xy.length()));
		char x = xy.toLowerCase().charAt(0);
		
		int r = y - 1;
		int c = ((int) x - 97);
		//System.out.println("Checking if grid[" + r + "][" + c + "] is empty: " + (grid[r][c].equals(" [ ] ")));
		return grid[r][c].equals(" [ ] ");
		
	}
	
	public void alterSpace(String xy, String change) {
		int y = Integer.valueOf(xy.substring(1, xy.length()));
		char x = xy.toLowerCase().charAt(0);
		
		int r = y - 1;
		int c = ((int) x - 97);
		grid[r][c] = " [" + change + "] ";
		//System.out.println("Changing grid[" + r + "][" + c + "] to ' [" + change + "] '");
	}
	
	public boolean checkFull() {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c].equals(" [ ] ")) {
					return false;
				}
			}
		}
		//System.out.println("Grid is full!");
		return true;
	}
}
