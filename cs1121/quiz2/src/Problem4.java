import java.util.*;

/**
 * @author Jeremy Sommerfeld
 * CS 1121, Fall 2013
 * Lab Section 6
 * 
 * This class will replace the value at associated with key with x if x is
 * double its current value or if there is no association.
 */
public class Problem4 {

	/**
	 * This method is a simple test driver for the quiz class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Empty test driver.

	}  //End main method.

	/**
	 * This method will replace the value at associated with key with x if x is
	 * double its current value or if there is no association.
	 * 
	 * @param map - The TreeMap that is being tested.
	 * @param key - the key for the association that is being tested.
	 * @param x - the value that may replace the current value at key.
	 */
	public static void quiz(TreeMap<String,Integer> map, String key, int x) {

		if (map.containsKey(key) == false || map.get(key) < 2*x) {
			map.put(key, x);
			
		}

	}  //End quiz method.
}  //End Problem4 class.
