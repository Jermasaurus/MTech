import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * @author Jeff McAndrews
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Kilograms  Pounds   Pounds   Kilograms%n");
		
		int count = 1;
		int pound2 = 20;
		
		while (count < 200) {
			double pound1 = count * 2.2;
			double kilo2 = pound2 / 2.2;
			System.out.printf("%-10d %-7.1f %-10d %-7.2f%n",count,pound1,pound2,kilo2);
			pound2 += 5;
			count += 2;
		}
		
	}

}
