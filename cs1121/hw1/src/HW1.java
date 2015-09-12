import java.util.Scanner;  //Scanner is in the java.util package

/**
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 *
 * Homework #1
 */

/**
 * This programs creates an ASCII rectangle with corners from 2 inputs.
 * @author jsommerf
 *
 */

//-----------------------------------------------------------------------------
//Begin main class for HW #1

public class HW1 {

	//-------------------------------------------------------------------------
	//Begin Main Method:
	public static void main(String[] args) {

		//Import Scanner for simple variable input:
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		//Input 2 int values from computer:
		int userRow = input.nextInt();
		int userCol = input.nextInt();

		//Initialize variables for calculations/loops
		int dotCount = 0;
		int row = 1;
		int col = 0;
		int rowHalf = 0;

		//Determines whether input is valid:
		if (userRow < 3 && userCol < 3) {
			System.out.println("Error: both rows and columns less than 3");  //Prints error message if both row and col are too small
		}
		else if (userRow < 3) {
			System.out.println("Error: rows less than 3");  //Prints error message if row is too small
		}
		else if (userCol < 3) {
			System.out.println("Error: columns less than 3");  //Prints error message if col is too small
		}
		else {
			//If rows are smallest or col/row are even:
			if (userRow <= userCol) { 
				if (userRow % 2 == 0) {
					dotCount = (userRow / 2) - 1;
				}
				else {
					dotCount = userRow / 2;;
				}
			}
			//If cols are smallest:
			else {
				if (userCol % 2 == 0) {
					dotCount = (userCol / 2) - 1;
				}
				else {
					dotCount = userCol / 2;
				}
			}

			//finds where to switch loops:
			rowHalf = userRow - dotCount;

			//Print out first half of ASCII rectangle:
			while (row <= rowHalf) {
				while (col < userCol){
					for (int i = 0; i < dotCount; i++) {  //Prints initial dots of each row
						System.out.print(".");
						col++;
					}
					for (int i = 0; i < userCol - (2 * dotCount); i++) {  //Prints x's of each row
						System.out.print("x");
						col++;
					}
					while (col < userCol) {  //Prints final dots of each row
						System.out.print(".");
						col++;
					}
				}
				if (row <= userRow) {
					System.out.println("");  //Prints newline for next row
					row++;
				}
				col = 0;
				if (dotCount > 0) {
					dotCount--;
				}
			}

			//Print out second half of ASCII rectangle:
			dotCount = 1;
			while (row > rowHalf && row <= userRow) {
				for (int i = 0; i < dotCount; i++) {  //Prints initial dots of each row
					System.out.print(".");
					col++;
				}
				for (int i = 0; i < userCol - (2 * dotCount); i++) {  //Prints x's of each row
					System.out.print("x");
					col++;
				}
				while (col < userCol) {  //Prints final dots of each row
					System.out.print(".");
					col++;
				}

				if (row < userRow) {
					System.out.println("");
				}
				col = 0;
				dotCount++;
				row++;
			}
		}
	}

	//-------------------------------------------------------------------------
	//End Main Method
}

//-----------------------------------------------------------------------------
//End main Class for HW #1