/**
 * CS3421 Spring 2015 Lab Assignment 1
 *
 * @author Jeremy Sommerfeld
 */
public class Lab1 {

	/**
	 * Print the decimal value of a binary number
	 *
	 * @param args
	 *            The identifier and binary string
	 */
	public static void main(String[] args) {

		// check command line
		if (args.length != 2) {
			System.err.println("Usage: java Lab1 <u,s,t> <binary_number>");
			System.exit(1);
		}
		String type = args[0];
		String binum = args[1];

		// Convert and print binum
		if (type.equals("u")) {
			// Unsigned
			double unsigned = 0;

			for (int i = 0; i < binum.length(); i++) {
				if (binum.charAt(i) == '1') {
					unsigned = unsigned + Math.pow(2, binum.length() - 1 - i);
				}
			}
			// Print out Decimal value
			System.out.println((int) unsigned);

		} else if (type.equals("s")) {
			// Sign-Magnitude
			double signMag = 0;

			// Take care of Most-significant-bit
			char sign = binum.charAt(0);
			binum = binum.substring(1);

			for (int i = 0; i < binum.length(); i++) {
				if (binum.charAt(i) == '1') {
					signMag = signMag + Math.pow(2, binum.length() - 1 - i);
				}
			}
			// Print out decimal value
			if (sign == '1') {
				System.out.print("-");
			}
			System.out.println((int) signMag);

		} else if (type.equals("t")) {
			// Two's compliment
			double twoComp = 0;
			
			// Take care of Most-significant-bit
			if (binum.charAt(0) == '1') {
				twoComp = 0 - Math.pow(2, binum.length() - 1);
			}
			binum = binum.substring(1);
			
			for (int i = 0; i < binum.length(); i++) {
				if (binum.charAt(i) == '1') {
					twoComp = twoComp + Math.pow(2, binum.length() - 1 - i);
				}
			}
			
			// Print out the decimal value
			System.out.println((int) twoComp);

		} else {
			System.out.println("Error:  Unexpected type.");
		}

		System.exit(0);

	} // end of main method
} // end of Lab1 class