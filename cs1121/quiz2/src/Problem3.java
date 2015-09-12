import java.util.*;

/**
 * @author Jeremy Sommerfeld
 * CS 1121, Fall 2013
 * Lab Section 6
 * 
 * This class inserts 0 between consecutive elements where the second is less than the first.
 *
 */
public class Problem3 {

	/**
	 * This method is a test driver for the method 'quiz'
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//Empty test driver

	}  //End main method

	/**
	 * This method inserts 0 between consecutive elements where the second is less than the first.
	 * @param data
	 */
	public static void quiz(ArrayList<Integer> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			if (data.get(i) > data.get(i+1)) {
				data.add(i+1, 0);
			}
		}
	}  //End quiz method
}  //End Problem 3 class
