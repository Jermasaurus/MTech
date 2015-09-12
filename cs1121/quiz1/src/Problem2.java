import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates scanner object for simple variable input.
		Scanner input = new Scanner(System.in);
		
		//Prompts user and inputs values.
		System.out.print("Enter three integers (a, b, c): ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		//Prints out statement if certain boolean operators are true.
		if (a + b == c) {
			System.out.println("a + b == c");
		}
		if (a - b == c) {
			System.out.println("a - b == c");
		}
		if (a * b == c) {
			System.out.println("a * b == c");
		}
		if (a / b == c) {
			System.out.println("a / b == c");
		}
	}

}
