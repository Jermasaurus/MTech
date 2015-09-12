import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * @author Jeff McAndrews
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create a scanner for input
		Scanner input = new Scanner(System.in);

		int count = 0;
				
		for (int i = 100; i <= 1000; i++){
			if(i % 5 == 0 && i % 6 == 0){
				System.out.print(i + " ");
				count++;
				if (count == 10){
					System.out.printf("%n");
					count = 0;
				}
			}
		}

	}

}

