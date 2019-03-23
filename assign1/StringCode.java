package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int res = 0;
		int currLen = 1;
		
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i - 1)) {
				currLen++;
			} else {
				currLen = 1;
			}
			res = Math.max(res, currLen);
		}
		
		return res; // TODO ADD YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String res = "";
		for(int i = 0; i < str.length(); i++) {
			char currCh = str.charAt(i);
			if(currCh >= '0' && currCh <= '9') {			
				if(i != str.length() - 1) {
					for(int j = 0; j < currCh - '0'; j++) {
						res += str.charAt(i + 1);;
					}					
				}
			} else {
				res += currCh;
			}
		}
		
		return res; // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(len > a.length() || len > b.length()) return false;
		HashSet<String> data = new HashSet<String>();
		
		for(int i = 0; i <= a.length() - len; i++) {
			data.add(a.substring(i, i + len));
		}
		
		for(int i = 0; i <= b.length() - len ; i++) {
			if(data.contains(b.substring(i, i + len))) return true;
		}
		
		return false; // TO DO ADD YOUR CODE HERE
	}
}
