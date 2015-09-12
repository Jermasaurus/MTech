//@author Jeremy Sommerfeld
//@author Jeff McAndrews

import java.util.Scanner;

public class Problem7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates new Scanner Object
		Scanner input = new Scanner(System.in);

		//Prompts user for number of minutes
		System.out.print("Enter the number of minutes: ");

		//Inputs minutes
		int min = input.nextInt();

		//Converts minutes to years and days
		int year = min / 525600;

		int remainder = min % 525600;

		int day = remainder / 1440;

		//Outputs values
		System.out.println(min + " minutes is approximately " + year + " years and " + day + " days.");	

	}

}
