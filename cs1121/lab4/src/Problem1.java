import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * @author Jeff McAndrews
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create a scanner for input
		Scanner input = new Scanner(System.in);

		//Prompt the user for input
		System.out.print("Enter an int value, the program exits if the input is 0: ");

		//initialize variables
		int data = 0;
		int neg = 0;
		int pos = 0;
		int total = 0;
		int count = 0;

		//runs while data is not = 0
		while ((data = input.nextInt()) != 0) {
			//Data is negative
			if (data < 0) {
				neg++;
				count++;
				total += data;
			}
			//Data is positive
			else {
				pos++;
				count++;
				total += data;
			}
		}
		//calculates average
		double avg = (double)total / count;
		
		//Prints out stuff
		System.out.println("The number of positives is " + pos);
		System.out.println("The number of negatives is " + neg);
		System.out.println("The total is " + total);
		System.out.printf("The average is %.2f%n", avg);
	}

}
