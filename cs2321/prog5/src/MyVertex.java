import java.util.ArrayList;

/**
 * Vertex functionality used to store vertices in a graph Based off of the interface provided in
 * Vertex.java
 * 
 * @author Jeremy Sommerfeld, Ethan Koeppe cs2321 - Fall 2014
 */
public class MyVertex implements Vertex {

    // List of all edges associated with this vertex.
    private ArrayList< Edge > edges;
    // List of all the adjacent vertices to this vertex
    private ArrayList< Vertex > adjacentVertices;
    // x and y coordinates of the vertex
    private Pair coordinates;

    /**
     * Default constructor for MyVertex
     */
    public MyVertex( ) {

        // Initialize ArrayList of edges
        edges = new ArrayList< Edge >( );

        adjacentVertices = new ArrayList< Vertex >( );

        coordinates = new MyPair( );

    }

    /**
     * Constructor for MyVertex that takes a Pair of coordinates as input
     * 
     * @param p
     *            A Pair of coordinates that locate the Vertex
     */
    public MyVertex( Pair p ) {
        // Initialize ArrayList of
        edges = new ArrayList< Edge >( );

        adjacentVertices = new ArrayList< Vertex >( );

        coordinates = new MyPair( );

        setElement( p );
    }

    /**
     * Getter for the Pair of coordinates in the Vertex
     * 
     * @return A Pair representing the x and y coordinates of the Vertex
     */
    public Pair getElement( ) {
        return coordinates;
    }

    /**
     * Setter for the Pair of coordinates in the Vertex
     * 
     * @param e
     *            A Pair of x and y coordinates for the Vertex
     */
    public void setElement( Pair e ) {
        coordinates.setX( e.getX( ) );
        coordinates.setY( e.getY( ) );
    }

    /**
     * Returns a list of all the incident edges of the Vertex
     * 
     * @return An ArrayList of all the incident edges of the Vertex
     */
    public ArrayList< Edge > incidentEdges( ) {
        return edges;
    }

    /**
     * Returns a list of all the adjacent vertices to the Vertex
     * 
     * @return An ArrayList of all the adjacent vertices to the Vertex
     */
    public ArrayList< Vertex > adjacentVertices( ) {
        return adjacentVertices;
    }

    /**
     * Creates a String representation of the Vertex
     * 
     * @return A String representation of the Vertex
     */
    public String toString( ) {
        return "<v" + coordinates + ">";
    }

}
