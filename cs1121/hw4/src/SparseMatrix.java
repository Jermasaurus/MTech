import java.util.*;

/**
 * A 2-D sparse matrix class.
 * 
 * @author Jeremy Sommerfeld
 *
 * CS1121, Fall 2013
 * Lab Section 6
 */
public class SparseMatrix {

	// instance variables (DO NOT CHANGE THE NEXT THREE LINES IN ANY WAY!)
	private final TreeMap<Integer,TreeMap<Integer,Double>> matrix;
	// the primary structure for keeping track of non-zero values
	private final int rows;
	// used to keep track of the number of rows, must be >0
	private final int cols;
	// used to keep track of the number of columns, must be >0

	/**
	 * Construct a new SparseMatrix object with a given number of rows and
	 * columns.
	 * Assume there is at least one row and one column.
	 *
	 * @param r The number of rows.
	 * @param c The number of columns.
	 */
	public SparseMatrix(int r, int c) {
		//Initializes the main matrix treemap.
		matrix = new TreeMap<Integer, TreeMap<Integer, Double>>();

		//Initializes the row and col count of the sparse Matrix:
		rows = r;
		cols = c;

	} // end of constructor

	/**
	 * Get the number of rows in this sparse matrix.
	 *
	 * @return the number of rows.
	 */
	public int numRows() {
		return rows;
	} // end of of numRows method

	/**
	 * Get the number of columns in this sparse matrix.
	 *
	 * @return the number of columns.
	 */
	public int numColumns() {
		return cols;
	} // end of of numColumns method

	/**
	 * Get the value at a given position.
	 *
	 * @param i The row.
	 * @param j The column.
	 *
	 * @return the value at row i and column j, or 0.0 if the position is
	 * 		not in the matrix.
	 */
	public double get(int i, int j) {
		if(matrix.containsKey(i)) {
			if (matrix.get(i).containsKey(j)) {
				return matrix.get(i).get(j);
			}
			else {
				return 0.0;
			}
		}
		else {
			return 0.0;
		}
	} // end of get method

	/**
	 * Change the value at a given position.
	 * If the position is not in the matrix (i.e., i is not between 0 and rows-1
	 * and j is not between 0 and cols-1), then don't change anything.
	 *
	 * @param i The row.
	 * @param j The column.
	 * @param v The new value.
	 */
	public void set(int i, int j, double v) {
		//Checks the input for validity.
		if (i <= 0 || i > rows ||j <= 0 || j > cols) {
			//if outside of range, do nothing
		}
		else if (Math.abs(v - 0.0) < 1e-4) {
			matrix.get(i).clear();
			if (matrix.get(i).isEmpty()) {
				matrix.remove(i);
			}
		}
		else {
			if (matrix.containsKey(i)) {
				matrix.get(i).put(j,  v);
			}
			else {
				matrix.put(i, new TreeMap<Integer, Double>());
				matrix.get(i).put(j,  v);
			}
		}
	} // end of set method

	/**
	 * See if this matrix is the identity matrix (i.e., square, 1's on the 
	 * diagonal, 0's elsewhere.
	 *
	 * @return true if it is the identity matrix, false if not.
	 */
	public boolean isIdentity() {
		if (rows == cols) {
			//initialize a counter to test a diagonal.
			int count = 0;

			for (Integer key : matrix.keySet()) {
				count++;
				if (matrix.get(key).containsKey(key)) {
					count++;
					if (Math.abs(matrix.get(key).get(key) - 1.0) < 1e-4) {
						if (count == rows) {
							return true;
						}
					}
				}
			}
		}
		return false;



	} // end of isIdentity method

	/**
	 * See if one matrix equals another.
	 * Two matrices are equal if the are the same size and every element of one
	 * is equal to the corresponding element of the other.
	 *
	 * @param a One matrix.
	 * @param b Another matrix.
	 *
	 * @return true if they are equal, false if not.
	 */
	public static boolean equals(SparseMatrix a, SparseMatrix b) {
		//Tests to see that the matrices are the same size.
		if (a.numRows() == b.numRows() && a.numColumns() == b.numColumns()) {

			//Initialize a counter.
			int countOut = 0;
			int countOutMax = a.matrix.size();
			int countIn = 0;
			int countInMax = a.matrix.get(a.matrix.lastKey()).size();

			for(Integer keysA : a.matrix.keySet()) {
				countOut++;
				countIn = 0;
				for(Integer inKeysA : a.matrix.get(keysA).keySet()) {
					countIn++;
					if(Math.abs(a.matrix.get(keysA).get(inKeysA) - b.matrix.get(keysA).get(inKeysA)) < 1e-4) {
						if(countOut == countOutMax && countIn == countInMax) {
							return true;
						}
					}
					else {
						break;
					}
				}
			}
		}
		return false;
	} // end of equals method

	/**
	 * Add two sparse matrices and return the sum.
	 * Two matrices must be the same size or they can't be added.
	 *
	 * @param a One matrix.
	 * @param b Another matrix.
	 *
	 * @return a new sparse matrix that is the sum of a and b, or the null
	 * 		pointer if they are not the same size.
	 */
	public static SparseMatrix add(SparseMatrix a, SparseMatrix b) {

		if (a.numRows() == b.numRows() && a.numColumns() == b.numColumns()) {
			//Initializes a new SparseMatrix 'c'.
			SparseMatrix c = new SparseMatrix(a.numRows(), a.numColumns());

			//Runs through all unique 'a' values and duplicates from 'b'
			for(Integer outA : a.matrix.keySet()) {
				for (Integer keyA : a.matrix.get(outA).keySet()) {
					c.set(outA, keyA, a.matrix.get(outA).get(keyA) + b.matrix.get(outA).get(keyA));
				}
			}

			//Runs through all unique 'b' values and duplicates from 'a'
			for(Integer outB : b.matrix.keySet()) {
				for (Integer keyB : a.matrix.get(outB).keySet()) {
					c.set(outB, keyB, a.matrix.get(outB).get(keyB) + b.matrix.get(outB).get(keyB));
				}
			}
			return c;
		}
		else {
			return null;
		}
	} // end of add method

	/**
	 * Return the toString of the map structure of this sparse matrix.
	 * DO NOT CHANGE THIS METHOD IN ANY WAY.
	 *
	 * @return toString of the map.
	 */
	public String toString() {

		return matrix.toString(); // do not modify, replace or delete this line
	} // end of toString method

	/**
	 * Test driver.
	 *
	 * @param args Unused.
	 */
	public static void main(String [] args) {

		HashMap<String,SparseMatrix> matrix =
				new HashMap<String,SparseMatrix>();

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a command: ");
		String cmd = input.next();
		while (!cmd.equals("end")) {
			if (cmd.equals("new")) {
				String name = input.next();
				int rows = input.nextInt();
				int cols = input.nextInt();
				if (rows < 1 || cols < 1) {
					System.out.println("new: rows and/or cols less than 1: ");
					System.exit(1);
				}
				SparseMatrix m = new SparseMatrix(rows,cols);
				int i = input.nextInt();
				while (i >= 0) {
					int j = input.nextInt();
					double v = input.nextDouble();
					m.set(i,j,v);
					i = input.nextInt();
				}
				matrix.put(name,m);
				System.out.printf("new %s = %s\n", name, m);
			}
			else if (cmd.equals("get")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numRows: no such matrix: " + which);
					System.exit(1);
				}
				int i = input.nextInt();
				int j = input.nextInt();
				System.out.printf("%s.get(%d,%d) = %f\n",
						which, i, j, matrix.get(which).get(i,j));
			}
			else if (cmd.equals("set")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numRows: no such matrix: " + which);
					System.exit(1);
				}
				int i = input.nextInt();
				int j = input.nextInt();
				double v = input.nextDouble();
				matrix.get(which).set(i,j,v);
				System.out.printf("%s.set(%d,%d,%f) = %s\n",
						which, i, j, v, matrix.get(which));
			}
			else if (cmd.equals("numRows")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numRows: no such matrix: " + which);
					System.exit(1);
				}
				System.out.printf("%s.numRows() = %d\n",
						which, matrix.get(which).numRows());
			}
			else if (cmd.equals("numColumns")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numColumns: no such matrix: " + which);
					System.exit(1);
				}
				System.out.printf("%s.numColumns() = %d\n",
						which, matrix.get(which).numColumns());
			}
			else if (cmd.equals("isIdentity")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("isIdentity: no such matrix: " + which);
					System.exit(1);
				}
				System.out.printf("%s.isIdentity() = %b\n",
						which, matrix.get(which).isIdentity());
			}
			else if (cmd.equals("equals")) {
				String a = input.next();
				if (!matrix.containsKey(a)) {
					System.out.println("equals: no such matrix: " + a);
					System.exit(1);
				}
				String b = input.next();
				if (!matrix.containsKey(b)) {
					System.out.println("equals: no such matrix: " + b);
					System.exit(1);
				}
				System.out.printf("%s.equals(%s) = %b\n", a, b,
						SparseMatrix.equals(matrix.get(a),matrix.get(b)));
			}
			else if (cmd.equals("add")) {
				String a = input.next();
				String b = input.next();
				if (!matrix.containsKey(b)) {
					System.out.println("add: no such matrix: " + b);
					System.exit(1);
				}
				String c = input.next();
				if (!matrix.containsKey(c)) {
					System.out.println("add: no such matrix: " + c);
					System.exit(1);
				}
				matrix.put(a,SparseMatrix.add(matrix.get(b),matrix.get(c)));
				System.out.printf("new %s = SparseMatrix.add(%s,%s) = %s\n",
						a, b, c, matrix.get(a));
			}
			else {
				System.out.println("invalid command: " + cmd);
				System.exit(1);
			}
			System.out.print("Enter a command: ");
			cmd = input.next();
		}

	} // end of main method

} // end of SparseMatrix class