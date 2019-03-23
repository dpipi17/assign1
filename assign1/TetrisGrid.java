//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int clearedRowNum = 0;
		boolean [][] newGrid = new boolean[grid.length][grid[0].length];
		int newRow = 0;
		
		for(int j = 0; j < grid[0].length; j++) {
			boolean isClearRow = true;
			for(int i = 0; i < grid.length; i++) {
				isClearRow = isClearRow && grid[i][j];
			}
			
			if(isClearRow) {
				clearedRowNum++;
			} else {
				for(int i = 0; i < grid.length; i++) {
					newGrid[i][newRow] = grid[i][j];
				}
				newRow++;
			}
		}
		
		for(int j = grid[0].length - 1; j >= grid[0].length - clearedRowNum; j--) {
			for(int i = 0; i < grid.length; i++) {
				newGrid[i][j] = false; 
			}
		}
		
		grid = newGrid;
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; 
	}
}
