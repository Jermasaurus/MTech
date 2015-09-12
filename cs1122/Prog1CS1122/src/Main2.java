import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Navigator nav = new Navigator();

		// load locations list from a file
		nav.loadLocations("cities2.txt");

		// print locations that were loaded
		System.out.println("Loaded " + nav.getNumLocations() + " cities: ");
		for (String city : nav.locationList())
			System.out.println("\t" + city + " has location id "
					+ nav.idOfLocation(city));
		System.out.println();

		// test location id of a non-existent location
		System.out.println("San Francisco is city "
				+ nav.idOfLocation("San Francisco"));
		System.out.println();

		// load distanced between locations from file
		nav.loadDistances("distances2.txt");
		System.out.println("Minimum distances table:");
		Navigator.printArray(nav.minDistanceArray());
		System.out.println();

		// find minimum distances between various locations
		int start = 0;
		int dest = 5;
		System.out.println("Distance from " + nav.getLocationName(start)
				+ " to " + nav.getLocationName(dest) + " is: "
				+ nav.minDistBetween(start, dest));
		start = 5;
		dest = 0;
		System.out.println("Distance from " + nav.getLocationName(start)
				+ " to " + nav.getLocationName(dest) + " is: "
				+ nav.minDistBetween(start, dest));
		start = 4;
		dest = 1;
		System.out.println("Distance from " + nav.getLocationName(start)
				+ " to " + nav.getLocationName(dest) + " is: "
				+ nav.minDistBetween(start, dest));
		start = 1;
		dest = 4;
		System.out.println("Distance from " + nav.getLocationName(start)
				+ " to " + nav.getLocationName(dest) + " is: "
				+ nav.minDistBetween(start, dest));
		System.out.println();

		// Call extra credit method
		System.out.println("Path from New York to Calumet is: '"
				+ nav.bestPath("New York", "Calumet") + "'");
		System.out.println("Path from Calumet to New York is: '"
				+ nav.bestPath("Calumet", "New York") + "'");
	}

	static void printFile(String filename) {
		try {
			Scanner in = new Scanner(new File(filename));
			System.out.println(filename + " contains:");
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			System.out.println("End of " + filename);
		} catch (FileNotFoundException e) {
			System.err.println(filename + " does not exist!");
		}
	}

}
