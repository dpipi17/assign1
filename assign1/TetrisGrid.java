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
		for(int j = 0; j < grid[0].length; j++) {
			for(int i = 0; i < grid.length; i++) {
				newGrid[i][j] = grid[i][j];
			}
			
		}
		
		int newRow = 0;
		for(int j = 0; j < newGrid[0].length; j++) {
			boolean isClearRow = true;
			for(int i = 0; i < newGrid.length; i++) {
				isClearRow = isClearRow && newGrid[i][j];
			}
			
			if(isClearRow) {
				clearedRowNum++;
			} else {
				for(int i = 0; i < newGrid.length; i++) {
					grid[i][newRow] = newGrid[i][j];
				}
				newRow++;
			}
		}
		
		for(int j = newGrid[0].length - 1; j >= newGrid[0].length - clearedRowNum; j--) {
			for(int i = 0; i < newGrid.length; i++) {
				grid[i][j] = false; 
			}
		}
		
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; 
	}
}
