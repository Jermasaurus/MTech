import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates scanner object for simple variable input.
		Scanner input = new Scanner(System.in);
		
		//Prompts user for input.
		System.out.print("Enter a number: ");
		int data = input.nextInt();
		
		//Declares Variables for calculation.
		int fib = 1;
		int fib1 = 0;
		int fib2 = 0;
		int temp = 1;
		
		/*
		System.out.print("DEBUG: ");
		while (fib < 55) {
			fib1 = fib;
			fib2 = temp;
			fib = fib1 + fib2;
			System.out.print(fib + " ");
			temp = fib1;
		}
		*/
		
		//Loops and checks if data is equal to fibonacci sequence.
		while (data != 0) {
			while (fib < data) {
			//calculate final fibonacci number
			fib1 = fib;
			fib2 = temp;
			fib = fib1 + fib2;
			temp = fib1;
			}
			
			//Tests if data is equal to the fibonacci sequence
			if (data == fib || data == 1) {
			System.out.println(data + " is a fibonacci number");
			}
			
			//Reprompts the user.
			System.out.print("Enter another number: ");
			data = input.nextInt();
		}

	}

}
