// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int westPoint = 0;
		int eastPoint = 0;
		int northPoint = 0;
		int southPoint = 0;
		boolean firstOccur = true;
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == ch) {
					if(firstOccur) {
						westPoint = col;
						eastPoint = col;
						northPoint = row;
						southPoint = row;
						firstOccur = false;
					} else {
						westPoint = Math.min(westPoint, col);
						eastPoint = Math.max(eastPoint, col);
						northPoint = Math.min(northPoint, row);
						southPoint = Math.max(southPoint, row);
					}
				}
			}
		}
		
		int area = (eastPoint - westPoint + 1) * (southPoint - northPoint + 1);
		if(firstOccur) return 0;
		return area; 
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int counter = 0;
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(isMiddleOfPlus(row, col)) {
					counter++;
				}
			}
		}
		
		return counter; // TODO ADD YOUR CODE HERE
	}
	
	// helper method, which guesses if the point is the middle of plus.
	private boolean isMiddleOfPlus(int middleRow, int middleCol) {
		char middleCh = grid[middleRow][middleCol];
		
		int leftArm = getLeftArmSize(middleRow, middleCol, middleCh);
		int rightArm = getRightArmSize(middleRow, middleCol, middleCh);
		int upArm = getUpArmSize(middleRow, middleCol, middleCh);
		int downArm = getDownArmSize(middleRow, middleCol, middleCh);
		
		
		if(leftArm < 2) return false;
		
		boolean isMiddleOfPlus = (leftArm == rightArm) && (leftArm == upArm) && (leftArm == downArm);
		
		return isMiddleOfPlus;
	}
	
	// gets length of left arm. consecutive characters started from the middle point to left.
	private int getLeftArmSize(int middleRow, int middleCol, char middleCh) {
		int leftArm = 1;
		for(int col = middleCol - 1; col >= 0; col--) {
			if(grid[middleRow][col] == middleCh) {
				leftArm++;
			} else {
				break;
			}
		}
		
		return leftArm;
	}
	
	// gets length of right arm. consecutive characters started from the middle point to right.
	private int getRightArmSize(int middleRow, int middleCol, char middleCh) {
		int rightArm = 1;
		for(int col = middleCol + 1; col < grid[0].length; col++) {
			if(grid[middleRow][col] == middleCh) {
				rightArm++;
			} else {
				break;
			}
		}
		
		return rightArm;
	}
	
	// gets length of up arm. consecutive characters started from the middle point to up.
	private int getUpArmSize(int middleRow, int middleCol, char middleCh) {
		int upArm = 1;
		for(int row = middleRow - 1; row >= 0; row--) {
			if(grid[row][middleCol] == middleCh) {
				upArm++;
			} else {
				break;
			}
		}
		
		return upArm;
	}
	
	// gets length of down arm. consecutive characters started from the middle point to down.
	private int getDownArmSize(int middleRow, int middleCol, char middleCh) {
		int downArm = 1;
		for(int row = middleRow + 1; row < grid.length; row++) {
			if(grid[row][middleCol] == middleCh) {
				downArm++;
			} else {
				break;
			}
		}
		
		return downArm;
	}
	
	
	
}
