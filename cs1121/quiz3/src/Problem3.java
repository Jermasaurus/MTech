import java.util.*;

/**
 * 
 * @author Jerry Sommerfeld
 * CS1121, Fall 2013
 * Lab Section 6
 * 
 * This class finds the largest value in a certain TreeMap.
 *
 */
public class Problem3 {

	/**
	 * The main method acts as a test driver for the action method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Empty Driver.
	}  //End main method.
	
	/**
	 * Finds the largest value in the given TreeMap with the given key.
	 * 
	 * @param map - the TreeMap
	 * @param key - the key in question
	 * @return - the largest value in the list for the given key.
	 */
	public static int action(TreeMap<String,ArrayList<Integer>> map, String key) {
		int max = 0;
		if(map.containsKey(key) && !map.get(key).isEmpty()) {
			
			ArrayList<Integer> data = new ArrayList<Integer>();
			data = map.get(key);
			
			for(int count = 0; count < data.size(); count++) {
				if (data.get(count) > max) {
					max = data.get(count);
				}
			}
			return max;
		}
		else {
			return -1;
		}
	}  //End action method.
}  //End Problem3 class.
