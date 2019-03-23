package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T, Integer> mapOfA = new HashMap<T, Integer>();
		Map<T, Integer> mapOfB = new HashMap<T, Integer>();
		
		countOccur(a, mapOfA);
		countOccur(b, mapOfB);
		
		int counter = 0;
		for(T key : mapOfA.keySet()) {
			if(mapOfB.containsKey(key)) {
				if(mapOfA.get(key).equals(mapOfB.get(key))) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	// counts occurance of elements in the collection
	private static <T> void countOccur(Collection<T> col, Map<T, Integer> map) {
		Iterator<T> iterator = col.iterator();
		 
        while (iterator.hasNext()) {
        	T nextElem = iterator.next();
        	
        	if(map.containsKey(nextElem)) {
        		int occur = map.get(nextElem);
        		map.put(nextElem, occur + 1);
        	} else {
        		map.put(nextElem, 1);
        	}
        }
	}
}
