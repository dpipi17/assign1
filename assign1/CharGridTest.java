// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	@Test
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{'a', 'b', ' '},
				{'b', 'a', 'b'},
				{' ', 'b', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(9, cg.charArea('a'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(0, cg.charArea('c'));
	}
	
	
	@Test
	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'a', 'b', ' ', 'z'},
				{'z', 'b', 'b', 'a'},
				{' ', 'a', 'a', 'b'},
				{' ', 'z', 'm', 'm'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(12, cg.charArea('a'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(16, cg.charArea('z'));
		assertEquals(2, cg.charArea('m'));
	}
	
	@Test
	public void testCharArea5() {
		char[][] grid = new char[][] {
				{'a', 'a', 'm', 'z'},
				{'b', 'b', 'b', 'a'},
				{'b', 'b', 'b', 'b'},
				{'a', 'z', 'm', 'm'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(16, cg.charArea('a'));
		assertEquals(8, cg.charArea('b'));
		assertEquals(12, cg.charArea('z'));
		assertEquals(8, cg.charArea('m'));
	}
	
	
	@Test
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{'a', 'b', 'c', 'd'},
				{'d', 'c', 'b', 'a'},
				{'a', 'b', 'c', 'd'},
				{'d', 'c', 'b', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.countPlus());
	}
	
	
	@Test
	public void testCountPlus2() {
		// only one plus with character 'c'
		char[][] grid = new char[][] {
				{'a', 'b', 'b', 'b', 'a', 'c'},
				{'d', 'c', 'b', 'a', 'a', 'a'},
				{'c', 'c', 'c', 'd', 'a', 'b'},
				{'d', 'c', 'b', 'a', 'a', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus3() {
		// none of them are pluses
		char[][] grid = new char[][] {
				{'a', 'a', 'a', 'a', 'a', 'a'},
				{'a', 'a', 'a', 'a', 'a', 'a'},
				{'a', 'a', 'a', 'a', 'a', 'a'},
				{'a', 'a', 'a', 'a', 'a', 'a'},
				{'a', 'a', 'a', 'a', 'a', 'a'},
				{'a', 'a', 'a', 'a', 'a', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.countPlus());
	}
	
	@Test
	public void testCountPlus4() {
		// only one plus. middle point of that plus is (3, 3)
		char[][] grid = new char[][] {
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a'}
		};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus5() {
		// three pluses. midlle points (1, 1) (2, 4) (1, 5)
		char[][] grid = new char[][] {
			{'a', ' ', 's', 's', 'a', 'a', 'm'},
			{' ', ' ', ' ', 's', 'a', 'a', 'a'},
			{'a', ' ', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'b', 'a', 'a', 'a', 'l', 'a'},
			{'b', 'b', 'b', 'c', 'a', 'a', 'a'},
			{'a', 'b', 'a', 'c', 'b', 'a', 'a'},
			{'a', 'b', 'c', 'c', 'c', 'a', 'a'}
		};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(3, cg.countPlus());
	}
}
