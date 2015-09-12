import java.util.Scanner;

/**
 * @author Jerry Sommerfeld
 * @author Jeff McAndrews
 * CS1121, Fall 2013
 * Lab Section 6
 */

public class Problem8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create a scanner for input
		Scanner input = new Scanner(System.in);
		
		//Prompts user for number of students
		System.out.print("Enter the number of students: ");
		int number = input.nextInt();
		
		int count = 0;
		String s = "";
		int a = 0;
		while (count < number) {
			//Prompts user for student name
			System.out.print("Enter a student's name: ");
			String name = input.next();
			
			//Prompts user for student score
			System.out.print("Enter that student's score: ");
			int score = input.nextInt();
			
			//Keeps highest value and name
			if (a < score){
				a = score;
				s = name;	
			}
			count ++;
		}
		
		System.out.println(s + " had the highest score.");
	}

}

