//@author Jeremy Sommerfeld
//@author Jeff McAndrews

import java.util.Scanner;

public class Problem4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create a scanner object
		Scanner input = new Scanner(System.in);

		//Prompts user for input in pounds.
		System.out.print("Enter a number in pounds: ");
		double pound = input.nextDouble();

		//Converts pounds to kilos and prints the value.
		double kilo = (pound * 0.454);
		System.out.println(pound + " pounds is " + kilo + " kilograms");
	}

}
