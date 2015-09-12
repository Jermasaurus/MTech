import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates scanner object for simple variable input.
		Scanner input = new Scanner(System.in);

		//Prompts user and grabs an input.
		System.out.print("Enter n: ");
		int n = input.nextInt();

		//Calculates factorial value based off input.
		double factorial = Math.pow((n/2.71828),n) * Math.pow((2 * 3.1416 * n),0.5);

		//Prints out computed factorial value.
		System.out.println("n! is approximately " + factorial);

	}

}
