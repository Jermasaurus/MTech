import java.util.*;

/**
 * 
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 * 
 * This class rotates doubles in an array.
 *
 */
public class Problem2 {

	/**
	 * Test driver for the rotate method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Empty test driver...
	}  // End main method.
	/**
	 * This method rotates values in an array of doubles to the right.
	 * 
	 * @param data
	 */
	public static void rotate(double[] data) {
		double temp = 0.0;
		double tempInit = data[0];
		int length = data.length - 1;
		
		for(int count = 0; count < length; count++) {
			if (count == 0) {
				temp = data[count];
				data[0] = data[length];
			}
			else {
				data[count+1] = data[count];
				data[count] = temp;
				
			}
		}
	}  //End rotate method.
}  //End Problem2 class.
