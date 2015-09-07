/**
 * Pair functionality used to store x and y coordinates. Based off of the interface provided in
 * Pair.java
 * 
 * @author Jeremy Sommerfeld, Ethan Koeppe cs2321 - Fall 2014
 */
public class MyPair implements Pair {

    // x and y values inside pair
    private int x;
    private int y;

    /**
     * Default constructor for MyPair
     */
    public MyPair( ) {
        // Set x and y to 0 initially
        setX( 0 );
        setY( 0 );
    }

    /**
     * Getter for the x value in the pair
     * 
     * @return the x value in the pair
     */
    public int getX( ) {
        return x;
    }

    /**
     * Setter for the x value in the pair
     * 
     * @param newVal
     *            The new value for x
     */
    public void setX( int newVal ) {
        x = newVal;
    }

    /**
     * Getter for the y value in the pair
     * 
     * @return the y value in the pair
     */
    public int getY( ) {
        return y;
    }

    /**
     * Setter for the y value in the pair
     * 
     * @param newVal
     *            the new value for y
     */
    public void setY( int newVal ) {
        y = newVal;
    }

    /**
     * Creates a String representation of the Pair
     * 
     * @return A String representation of the Pair
     */
    public String toString( ) {
        return "(" + x + "," + y + ")";
    }

}
