import java.io.*;
import java.util.Scanner;

public class Navigator {

	//Create the variables needed:
	int locCount = 0;
	String[] locList;
	double[][] distances;

	/**
	 * This Method loads a list of locations from a file with a filename passed to the method.
	 * 
	 * @param fname - name of file to read from.
	 * @throws Exception
	 */
	public void loadLocations(String fname) throws Exception {
		//Scan in the Cities file:
		Scanner in = new Scanner(new File(fname));

		locCount = in.nextInt();
		in.nextLine();

		locList = new String[locCount];

		//Loop through file and get city names:
		for (int i = 0; i < locCount; i++) {
			locList[i] = in.nextLine();
		}
		//Close the City Name file -- DO THIS LAST.
		in.close();
	}

	/**
	 * This method returns an array which is a list of the locations.
	 * 
	 * @return locList - an Array of strings including the names of the locations.
	 */
	public String[] locationList() {
		return locList;
	}

	/**
	 * This method loads a list of distances between two locations from a file that has a
	 * filename that has been passed to the method.
	 * 
	 * @param fname - name of the file to read from.
	 * @throws Exception
	 */
	public void loadDistances(String fname) throws Exception {
		//Set size of the distances array:
		distances = new double[locCount][locCount];

		//Loads the array with dummy numbers to begin with.
		double big = Double.MAX_VALUE / 2.0;

		for(int i = 0; i < locCount; i++) {
			for(int j = 0; j < locCount; j++) {
				distances[i][j] = big;

				if(i == j) {
					distances[i][j] = 0.0;
				}
			}
		}

		//Scan in the Distances file:
		Scanner in = new Scanner(new File(fname));

		//places input from file into array:
		while(in.hasNext()) {
			distances[in.nextInt()][in.nextInt()] = in.nextDouble();
		}

		//Close the Distances file -- DO THIS LAST.
		in.close();

		//Run the Algorithm to get min distances.
		int k = 0;
		while (k < locCount) {
			for(int i = 0; i < locCount; i++) {
				for(int j = 0; j < locCount; j++) {
					if(i == j) {
						//do nothing, it's the identity matrix
					}
					else {
						if(distances[i][j] >= (distances[i][k] + distances[k][j])) {
							distances[i][j] = (distances[i][k] + distances[k][j]);
						}
					}
				}
			}
			k++;
		}
	}

	/**
	 * This method returns the array of distances between locations.
	 * 
	 * @return distances - the array of distances between locations.
	 */
	public double[][] minDistanceArray() {
		return distances;
	}

	/**
	 * This method returns the number of locations that are being processed.
	 * 
	 * @return locCount - the number of locations
	 */
	public int getNumLocations() {
		return locCount;
	}

	/**
	 * This method returns a string which is the name of the location with the passed id
	 * 
	 * @param id - The id number of the location being processed.
	 * @return a string which is the name of the location at 'id'.
	 * @return "invalid location" - returned if the id passed is out of range.
	 */
	String getLocationName(int id) {
		if(id < locCount && id >= 0) {
			return locList[id];
		}
		else {
			return "invalid location";
		}
	}

	/**
	 * This method is passed a string and then matches said string with the id number of
	 * the passed location name.
	 * 
	 * @param name - the passed location name
	 * @return i - the id number of the passed location name.
	 * @return -1 - returned if the string passed is not a valid location.
	 */
	int idOfLocation(String name) {
		for(int i = 0; i < locList.length; i++) {
			if(name.equals(locList[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method returns the minimum distance between two locations using the minDistanceArray
	 * of locations and their distances.
	 * 
	 * @param start - the id number of the starting location
	 * @param end - the id number of the ending location
	 * @return - returns the distance between start and end
	 */
	public double minDistBetween(int start, int end) {
		return distances[start][end];
	}

	/**
	 * This method writes an output file based on an input list of start and end locations.
	 * 
	 * @param input - the name of the file that contains the inputs
	 * @param output - the name of the file to be written
	 * @throws Exception
	 */
	public void processFile(String input, String output) throws Exception {
		//Reads in from input file:
		Scanner in = new Scanner(new File(input));
		int a;
		int b;
		
		//Creates a new output file:
		PrintWriter out = new PrintWriter(new File(output));
		
		while(in.hasNext()) {
			a = in.nextInt();
			b = in.nextInt();
			out.println(getLocationName(a) + "," + getLocationName(b) + "," + minDistBetween(a, b));
		}
		
		//Close both input and output files:
		in.close();
		out.close();
		
	}

	/**
	 * This method prints out the path to be taken to achieve the minimum distance between two locations.
	 * I was unable to complete it, so it is left blank.
	 * 
	 * @param start - the starting location.
	 * @param end - the ending location
	 * @return - the path taken to travel between 'start' and 'end'
	 */
	public String bestPath(String start, String end) {
		return "";
	}

	/**
	 * Prints the contents of a two dimensional array of doubles to console for
	 * debugging purposes.
	 * 
	 * @param arr - The array to be printed
	 */
	public static void printArray(double[][] arr) {
		if (arr.length == 0) {
			System.out.println("Zero sized array.");
			return;
		}
		System.out.println(arr.length + " by " + arr[0].length + " array:");
		for (int r = 0; r < arr.length; ++r) {
			for (int c = 0; c < arr[r].length; ++c) {
				System.out.printf("% 8.2f", arr[r][c]);
			}
			System.out.println();
		}
	}

}