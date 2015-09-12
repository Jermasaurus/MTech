//@author Jeremy Sommerfeld
//@author Jeff McAndrews

import java.util.Scanner;

public class Problem13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates new Scanner Object
		Scanner input = new Scanner(System.in);

		//Prompts user for investment amount
		System.out.print("Enter investment amount: ");
		double a = input.nextDouble();

		//Prompts for annual interest rate
		System.out.print("Enter annual interest rate: ");
		double b = input.nextDouble();
		b = (b/1200) + 1;

		//Prompts for number of years
		System.out.print("Enter number of years: ");
		double t = input.nextDouble();
		t = (t * 12);

		//Do math son
		double y = (a * (Math.pow(b,t)));

		//Print output
		System.out.println("Accumulated value is " + y);

	}

}
