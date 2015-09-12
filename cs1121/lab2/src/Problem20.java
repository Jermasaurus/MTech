//@author Jeremy Sommerfeld
//@author Jeff McAndrews

import java.util.Scanner;

public class Problem20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates new Scanner Object
		Scanner input = new Scanner(System.in);
		
		//Prompts user for first point
		System.out.print("Enter x1 and y1: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		
		//Prompts user for 2nd point
		System.out.print("Enter x2 and y2: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		//Break it down...
		double d = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
		
		//Output
		System.out.println("The distance of the two points is " + d);
		
	}

}
