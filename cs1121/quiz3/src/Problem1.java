import java.util.Scanner;
import java.util.*;

/**
 * 
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 * 
 * This class tests numbers for being within a 5 digit range.
 *
 */
public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Creates new Scanner Object
		Scanner input = new Scanner(System.in);

		int fiveDigits = 0;
		int largest = 0;
		int val = 1;

		while(true){
			val = input.nextInt();
			if(val < 1) {
				break;
			}
			
			if (val >= 10000 && val <= 99999) {  //finds if number is within 5 digits
				fiveDigits++;
				if (val > largest) {
					largest = val;
				}
			}
		}  //End For-loop
		
		System.out.println(fiveDigits);
		System.out.println(largest);

	}  //End main method

}  //End Problem1 Class
