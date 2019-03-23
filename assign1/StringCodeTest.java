// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	//
	// blowup
	//
	StringCode strCode = new StringCode();
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", strCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", strCode.blowup("2x3Z"));
	}
	
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	// TODO Need test cases for stringIntersect
	@Test
	public void intersectTest1() {
		assertEquals(false, StringCode.stringIntersect("123", "1234", 5));
		assertEquals(false, StringCode.stringIntersect("123", "134256", 2));
		assertEquals(false, StringCode.stringIntersect("abcdefg", "abc", 4));
	}
	
	@Test
	public void intersectTest2() {
		assertEquals(true, StringCode.stringIntersect("123", "1234", 1));
		assertEquals(true, StringCode.stringIntersect("123", "1234", 2));
		assertEquals(true, StringCode.stringIntersect("123", "1234", 3));
	}
	
	@Test
	public void intersectTest3() {
		assertEquals(true, StringCode.stringIntersect("demetre", "deme", 4));
		assertEquals(false, StringCode.stringIntersect("dimitri", "de", 2));
		assertEquals(false, StringCode.stringIntersect("OWP", "OP", 2));
	}
}
