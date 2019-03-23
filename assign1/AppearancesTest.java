package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	Appearances app = new Appearances();
	
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, app.sameCount(a, b));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, app.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, app.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, app.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	
	@Test
	public void testSameCount3() {
		// basic List<Double> cases
		List<Double> a = Arrays.asList(0.1, 0.1, 7.7, 1.3, 2.2, 2.2, 5.0);
		assertEquals(1, app.sameCount(a, Arrays.asList(0.1, 9.3, 9.2, 0.1)));
		assertEquals(0, app.sameCount(a, Arrays.asList(0.1, 2.2, 3.3, 1.0)));
		assertEquals(4, app.sameCount(a, Arrays.asList(0.1, 1.3, 7.7, 0.1, 5.0)));
	}
	
	@Test
	public void testSameCount4() {
		List<String> a = stringToList("aabbcccdddd");
		List<String> b = stringToList("aabbbccdddd");
		assertEquals(2, app.sameCount(a, b));	
	}
	
	// TODO Add more tests
}
