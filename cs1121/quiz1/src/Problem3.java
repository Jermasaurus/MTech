import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates scanner object for simple variable input.
		Scanner input = new Scanner(System.in);

		//Prompts user and grabs input.
		System.out.print("Enter n: ");
		int n = input.nextInt();

		//Calculates value.
		double total = 0.0;
		for (int i = n; i >= 1; i--) {
			total = total + (1.0 / i);
		}

		//Prints out calculated value.
		System.out.println(total);
	}

}
