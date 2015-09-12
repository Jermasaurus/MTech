import java.util.*;  //Imports everything necessary.

//Begin HW3 class *************************************************************
/**
 * @author Jerry Sommerfeld
 * cs1121 Fall 2013
 * Lab Section 6
 * 
 * Homework #3
 * This class contains a method that finds a Waldo image inside a larger image.
 * 
 */
public class HW3 {

	//Begin main method -------------------------------------------------------
	/**
	 * This method is a testing driver for the findWaldo method.
	 * Hopefully, everything will work...
	 * 
	 * @param args
	 */
	//	public static void main(String [] args) {
	//
	//		//char [][] testImage = {{
	//
	//		//char[][] testWaldo = { {W, w, ., ., ., W, 1}, {., A, a, ., a, ., 2}, {., ., L, l, ., ., 3}, {., d, ., D, d, ., 4}, {o, ., ., o, O, ., 5} };
	//
	//		int [][] testImage = { {1, 2, 3},
	//				{4, 5, 6},
	//				{7, 9, 8} };
	//
	//		int [][] testWaldo = { {8} };
	//
	//
	//
	//		System.out.println(Arrays.toString(findWaldo(testImage, testWaldo)));
	//
	//
	//
	//
	//	} //End main method -------------------------------------------------------


	//Begin findWaldo ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	/**
	 * This method takes two inputs, an image and a Waldo image to find and
	 * returns the places at which the Waldo image is found.
	 * 
	 * @param image - input for the image that the method is looking for
	 * 				  Waldo in
	 * @param waldo - input for what the method is looking for.
	 * 
	 * @return - returns places in the image where the Waldo image is found.
	 */
	public static int[] findWaldo(char [][] image, char [][] waldo) {

		int waldoStart = waldo[0][0];
		int waldoRow = 0;
		int waldoCol = 0;
		ArrayList<Integer> waldoPlace = new ArrayList<Integer>();

		for (int rowCount = 0; rowCount < image.length; rowCount++) {
			for (int colCount = 0; colCount < image[0].length; colCount++) {
				if (image[rowCount][colCount] == waldoStart) {

					for (int waldoTempRow = 0; waldoTempRow < waldo.length; waldoTempRow++) {
						for (int waldoTempCol = 0; waldoTempCol < waldo[0].length; waldoTempCol++) {
							if (image[rowCount + waldoTempRow][colCount + waldoTempCol] == waldo[waldoTempRow][waldoTempCol] || waldo[waldoTempRow][waldoTempCol] == '.') {

								if (waldoTempRow == waldo.length - 1 && waldoTempCol == waldo[0].length - 1){

									//Adds matching values to an array list for returning.
									waldoPlace.add(rowCount);
									waldoPlace.add(colCount);
								}
								else if (waldoTempRow == waldo.length - 1) {

									waldoTempCol = 0;
									waldoTempRow++;
								}
								else {
									waldoTempCol++;
								}
							}
						}
					}
				}
				else {
					waldoRow = 0;
					waldoCol = 0;
				}
			}
		}
		if (waldoPlace.size() == 0) {
			return null;
		}
		else {
			//Converts the array list to an array for returning.
			int [] finalPos = new int [waldoPlace.size()];
			for (int i = 0; i < waldoPlace.size(); i++) {
				finalPos[i] = waldoPlace.get(i);
			}
			return finalPos;
		}
	} //End findWaldo method ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
} //End HW3 Class *************************************************************