import java.util.*;

/**
 * @author Jeremy Sommerfeld
 * CS 1121, Fall 2013
 * Lab Section 6
 * 
 * This class tests two values to see if one is twice the other.
 *
 */
public class Problem1 {

	/**
	 * This is a testing driver for the method named 'quiz'.
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		//System.out.prinln(quiz(6, 3));

	}  //End main method
	
	/**
	 * This method returns true if 'a' is exactly two times 'b', or 'b' is two times 'a'
	 * @param a - the first integer
	 * @param b - the second integer
	 * @return - returns true or false depending on the test.
	 */
	public static boolean quiz(int a, int b) {
		
		if (a == 2*b || b == 2*a) {
			return true;
		}
		else {
			return false;
		}	
	}  //End quiz method
}  //End Problem1 class
