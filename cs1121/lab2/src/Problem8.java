//@author Jeremy Sommerfeld
//@author Jeff McAndrews

import java.util.Scanner;

public class Problem8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creates new Scanner Object
		Scanner input = new Scanner(System.in);
		
		//Prompts user for input
		System.out.print("Enter an ASCII code: ");
		
		//recieves input
		int code = input.nextInt();
		
		//convert code to character
		char ch = (char)code;
		
		//output
		System.out.println("The character for ASCII code " + code + " is " + ch);

	}

}
