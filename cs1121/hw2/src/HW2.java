import java.util.*;

/**
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 *
 * Homework #1
 * 
 * This Program finds if one skyline hides another.  If there is no place in
 * which the skyline is hidden, it returns the places where the showing skyline
 * is the least.
 */

//Begin HW2 class: ------------------------------------------------------------
public class HW2 {


	//Begin main Method: ------------------------------------------------------
	/**
	 * This method is a driver for the hide function for testing purposes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int [] testFront = {3, 1, 2, 3, 4, 3, 1, 3, 3, 2, 0, 1, 0};
		int [] testBack1 = {2, 3, 1};

		int [] testBack2 = {4, 4};

		//Prints out results from first test case:
		System.out.println(Arrays.toString(hide(testFront, testBack1)));

		//Prints out results from second test case:
		System.out.println(Arrays.toString(hide(testFront, testBack2)));



	}
	//End main Method: --------------------------------------------------------

	
	//Begin hide Method: ------------------------------------------------------
	/**
	 * See if one skyline hides another.
	 *
	 * @param front The front skyline.
	 * @param back The back skyline.
	 *
	 * @return an array representing one of two things:
	 *     if the front skyline hides the back one, the array contains
	 *     the leftmost (smallest) positions in the front array where the back
	 *     array is completely hidden (in increasing order);
	 *     if the front skyline does not hide the back one, the array contains
	 *     the negatives of all the leftmost (smallest) positions in the front
	 *     array that minimize the amount of the back skyline showing (in
	 *     increasing order).
	 */
	public static int[] hide(int [] front, int [] back) {

		ArrayList<Integer> hidden = new ArrayList<Integer>();

		int j = 0; //Initializes j as a counter for the back array.

		for (int i = 0; i < front.length; i++) {
			while (j < back.length) {
				if (front[i + j] >= back[j]) {
					if (j == back.length - 1) {
						hidden.add(i);
						j = 0;
						break;
					}
					j++;
				}
				else {  //resets j and starts the while loop all over at a new point.
					//System.out.println("DEBUG: Error at point: " + i+j);
					j = 0;
					break;
				}
			}

		}

		if (hidden.size() == 0) {
			
			//Minimizing variables:
			int min = 0;
			int minTotal = 0;
			int oldMinTotal = -20;

			//Finds smallest minimizing value:
			for (int i = 0; i < front.length; i++) {

				minTotal = 0;

				while (j < back.length && i + j < front.length) {

					if (front[i + j] - back[j] >= 0) {
						min = 0;
						minTotal = minTotal + min;
						j++;
					}
					else {
						min = front[i + j] - back[j];
						minTotal = minTotal + min;
						j++;
					}
					if (j == back.length) {
						if (minTotal >= oldMinTotal) {
							oldMinTotal = minTotal;
							break;
						}
					}
				}
				j = 0;
			}

			//Adds minimized values to the array:
			for (int i = 0; i < front.length; i++) {
				minTotal = 0;
				while (j < back.length && i + j < front.length) {
					if (front[i + j] - back[j] >= 0) {
						min = 0;
						minTotal = minTotal + min;
						j++;
					}
					else {
						min = front[i + j] - back[j];
						minTotal = minTotal + min;
						j++;
					}
					if (j == back.length) {
						if (minTotal == oldMinTotal) {
							hidden.add(-i);
							break;
						}
					}
				}
				j = 0;
			}
		}
		
		//Only new code for resubmission: (I also changed the return type).
		int[] hiddenArray = new int[hidden.size()];
		for(int count = 0; count < hidden.size(); count++) {
			hiddenArray[count] = hidden.get(count);
		}
		
		//Returns the ArrayList hidden, which contains values where back is hidden or minimized.
		return hiddenArray;
	}
	//End hide Method: --------------------------------------------------------
}
//End HW2 Class: --------------------------------------------------------------
