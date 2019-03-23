// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TabooTest {
	@Test
	public void testNoFollow1() {
		List<String> rule = Arrays.asList("a", "b", null, "c", "d");
		Taboo<String> tab = new Taboo<String>(rule);
		
		Set<String> s1 =  new HashSet<String>(Arrays.asList("b"));
		assertTrue(s1.equals(tab.noFollow("a")));
		
		Set<String> s2 =  new HashSet<String>(Arrays.asList("d"));
		assertTrue(s2.equals(tab.noFollow("c")));
		
		assertTrue(tab.noFollow("b").isEmpty());
	}
	
	@Test
	public void testNoFollow2() {
		List<String> rule = Arrays.asList("a", "c", "a", "b");
		Taboo<String> tab = new Taboo<String>(rule);
		
		Set<String> s1 =  new HashSet<String>(Arrays.asList("b", "c"));
		assertTrue(s1.equals(tab.noFollow("a")));
		
		Set<String> s2 =  new HashSet<String>(Arrays.asList("a"));
		assertTrue(s2.equals(tab.noFollow("c")));
		
		assertTrue(tab.noFollow("b").isEmpty());
	}
	
	@Test
	public void testNoFollow3() {
		List<Integer> rule = Arrays.asList(1, 2, 3, 1, 5, 3, 1, 4, 3, 5, 2, 1, 3);
		Taboo<Integer> tab = new Taboo<Integer>(rule);
		
		Set<Integer> s1 =  new HashSet<Integer>(Arrays.asList(2, 5, 4, 3));
		assertTrue(s1.equals(tab.noFollow(1)));
		
		Set<Integer> s2 =  new HashSet<Integer>(Arrays.asList(3, 1));
		assertTrue(s2.equals(tab.noFollow(2)));
		
		Set<Integer> s3 =  new HashSet<Integer>(Arrays.asList(1, 5));
		assertTrue(s3.equals(tab.noFollow(3)));
		
		Set<Integer> s4 =  new HashSet<Integer>(Arrays.asList(3));
		assertTrue(s4.equals(tab.noFollow(4)));
		
		Set<Integer> s5 =  new HashSet<Integer>(Arrays.asList(2, 3));
		assertTrue(s5.equals(tab.noFollow(5)));
		
	}
	
	@Test
	public void testReduce1() {
		List<String> rule = Arrays.asList("a", "c", "a", "b");
		Taboo<String> tab = new Taboo<String>(rule);
		
		List<String> reduced = new ArrayList<String>(Arrays.asList("a", "x", "c"));
		List<String> beforeReduce = new ArrayList<String>(Arrays.asList("a", "c", "b", "x", "c", "a"));
		tab.reduce(beforeReduce);
		assertTrue(reduced.equals(beforeReduce));
		
	}
	
	@Test
	public void testReduce2() {
		List<String> rule = Arrays.asList("a", "c", "a", "b");
		Taboo<String> tab = new Taboo<String>(rule);
		
		List<String> reduced = new ArrayList<String>(Arrays.asList("a", "a"));
		List<String> beforeReduce = new ArrayList<String>(Arrays.asList("a", "c", "b", "c", "c", "a"));
		tab.reduce(beforeReduce);
		assertTrue(reduced.equals(beforeReduce));
		
	}
	
	@Test
	public void testReduce3() {
		List<String> rule = Arrays.asList("a", "a", "b");
		Taboo<String> tab = new Taboo<String>(rule);
		
		List<String> reduced = new ArrayList<String>(Arrays.asList("a"));
		List<String> beforeReduce = new ArrayList<String>(Arrays.asList("a", "a", "b", "a", "b", "a"));
		tab.reduce(beforeReduce);
		assertTrue(reduced.equals(beforeReduce));
		
	}
}
