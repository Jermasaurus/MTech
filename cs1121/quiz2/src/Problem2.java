import java.util.*;

/**
 * @author Jeremy Sommerfeld
 * CS 1121, Fall 2013
 * Lab Section 6
 * 
 * This class moves values in an array after an index 'k'.
 *
 */
public class Problem2 {

	/**
	 * This is a testing driver for the method 'quiz'
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Empty test driver
		
	}  //End main method
	
	/**
	 * This method moves the value at index 'k' to the end of the array, and moves elements
	 * after the moved one to the empty spot to make room at the end.
	 * 
	 * @param data - the array that is being altered
	 * @param k - the index value that is being altered
	 */
	public static void quiz(int data[], int k) {
		
		int tempFinal = data[k];
		int temp = 0;
		
		for (int i = k; i < data.length-1; i++) {
			temp = data[i+1];
			data[i] = temp;
		}
		data[data.length - 1] = tempFinal;
		
	}  //End quiz method
}  //End Problem 2 class
