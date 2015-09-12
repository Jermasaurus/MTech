/**
 * @author Jeremy Sommerfeld
 * 			CS1122 Spring 2014
 */
public class Recursion {
    public Recursion(){
    	
    }
    
    /**
	 * Problem 1:
	 * 
	 * Find the reverse of the given string by using recursive calls.
	 * 
	 * DO NOT ALTER THE SIGNATURE OF THIS METHOD!
	 * 
	 * @param s  -- the string to reversed
	 * @return -- the reverse of the string        
	 */
	public static String reverse(String s) {	
		
		if(s.length() == 0) {
			return s;
		}
		
		return reverse(s.substring(1)) + s.charAt(0);
	}
    
    /**
     * Problem 2
     * 
     * A palindrome is a word that reads the same both forward and backward, 
     * like "otto" and "madam". A recursive definition of a palindrome is either 
     * an empty string or whose first letter is the same as the last letter, and whose
     * middle is a palindrome.
     * 
     * Fill in the body of isPanlindrome so that it 
     * returns true if the parameter string is a palindrome.  
     * 
     * DO NOT ALTER THE SIGNATURE OF THIS METHOD!
     * 
     * @param s -- a string 
     * @return -- true if the input string s is a palindrome, otherwise false
     */
    public static boolean isPalindrome(String s){
    	
    	if(s.length() == 0 || s.length() == 1) {
    		return true;
    	}
    	
    	if(s.charAt(0) == s.charAt(s.length() - 1)) {
    		return isPalindrome(s.substring(1, s.length() - 1));
    	}
    	
    	return false;
	}
    
    /**
     * Problem 3
     * 
     * Write a recursive function to find the maximum digit in an integer.
     * For example, digit 5 is the largest digit in 14563.
     * 
     * DO NOT ALTER THE SIGNATURE OF THIS METHOD!
     * 
     *  @param num -- an integer which could be negative, positive, or zero
     *  @return  -- the largest digit of the input integer number, num
     */
    public static int largestDigit(int num){
    	
    	num = Math.abs(num);
    	
    	if(num == 0) {
    		return 0;
    	}
    	
    	return Math.max(num%10, largestDigit(num/10));	
    }
    
    /**
     * Problem 4
     * 
     * Write a recursive function to replace all occurrence of a letter in 
     * a string with the given letter.  For example, given a string "steven"
     * If we want to replace all occurrence of e by a, then the function will
     * return "Stavan".
     * 
     * 
     * DO NOT ALTER THE SIGNATURE OF THIS METHOD!
     * 
     * @param s -- an input string
     * @param from -- which letter of the input string that we want to replace
     * @param to  -- the letter we want to replace with
     * @return -- return a string which have replaced all occurrence of letter 
     *            'from' with letter 'to'
     */
    public static String replace(String s, char from, char to){
    	
    	if(s.length() == 0) {
    		return "";
    	}
    	else if(s.startsWith(Character.toString(from))){
    		return "" + to + replace(s.substring(1), from, to);
    	}
    	else {
    		return "" + s.charAt(0) + replace(s.substring(1), from, to);
    	}
    }
    
    /**
	 * Problem 5:
	 * 
	 * Test an array to see if it contains a strictly increasing series of
	 * integers.
	 * 
	 * DO NOT ALTER THE SIGNATURE OF THIS METHOD
	 * 
	 * @param array -- an int array
	 * @return -- true if the given array contains a series of increasing integers;
	 * false otherwise
	 */
	public static boolean isIncreasing(int[] array) {
		
		if(array.length == 0 || array.length == 1) {
			return true;
		}
		
		int[] subArray = new int[array.length - 1];
		System.arraycopy(array, 1, subArray, 0, array.length - 1);
		
		if(array[0] < subArray[0]) {
			return isIncreasing(subArray);
		}
		
		return false;
	}
	
	
	/**
	 * Problem 6
	 * 
	 * Write a recursive function to check if it is possible to select some 
	 * subset of the n elements of the array so that the selected elements
	 * add up exactly to goal. 
	 * 	 
	 * DO NOT ALTER THE SIGNATURE OF THIS METHOD
	 * 
	 * @param array  -- an int array
	 * @param n  -- the number of elements selected from the array
	 * @param goal  -- the sum of the elements in the selected subset
	 * @return  -- true if it is possible to select n elements from the 
	 *             array and their summation is exactly equal to goal, otherwise
	 *             false. 
	 */
	public static boolean subsetSum(int[] array, int n, int goal){
		
		if(array.length == 1 && array[0] == goal) {
			return true;
		}
		else if(array.length == 1) {
			return false;
		}
		
		if(n == 0 && goal == 0) {
			return true;
		}
		
		int a = array[0];
		int[] subArray = new int[array.length - 1];
		System.arraycopy(array, 1, subArray, 0, array.length - 1);
		
		if(a <= goal) {
			return subsetSum(subArray, n-1, goal - a);
		}
		else {
			return subsetSum(subArray, n, goal);
		}
	}
		
	
}
