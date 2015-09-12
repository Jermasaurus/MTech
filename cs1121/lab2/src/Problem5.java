//@author Jeremy Sommerfeld
//@author Jeff McAndrews

import java.util.Scanner;

public class Problem5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//creates new scanner object
		Scanner input = new Scanner(System.in);

		//Prompts user for subtotal and gratuity rate.
		System.out.print("Enter the subtotal and a gratuity rate: ");

		//Inputs subtotal and gratuity rate.
		double sub = input.nextDouble();
		double grat = input.nextDouble();

		//Converts
		double gratTot = ((grat / 100) * sub);
		double total = (sub + gratTot);

		//outputs results
		System.out.printf("The gratuity is %.2f  and total is %.2f", gratTot,total);

	}

}
