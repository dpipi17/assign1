/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	Map<T, Set<T>> data;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		data = new HashMap<T, Set<T>>();
		
		T elem = null;
		for(T nextElem : rules) {
			if(elem != null && nextElem != null) {	
				
				if(data.containsKey(elem)) {
					Set<T> currS = data.get(elem);
					currS.add(nextElem);
					data.put(elem, currS);
				} else {
					Set<T> newS = new HashSet<T>();
					newS.add(nextElem);
					data.put(elem, newS);
				}
			}
			
			elem = nextElem;
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		if(data.containsKey(elem)) {
			return data.get(elem);
		} else {
			 return Collections.emptySet(); 
		}
		 
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		T lastElem = null;
		Iterator<T> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			T curr = iterator.next();
			if(lastElem != null) {
				if(data.containsKey(lastElem) && data.get(lastElem).contains(curr)) {
					iterator.remove();
				} else {
					lastElem = curr;
				}
			} else {				
				lastElem = curr;
			}

		}
		
	}
}
