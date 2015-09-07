import java.util.ArrayList;

/**
 * Basic edge functionality used in the MyGraph and MyMaze classes. Based off of the interface
 * provided in Edge.java
 * 
 * @author Jeremy Sommerfeld, Ethan Koeppe cs2321 - Fall 2014
 */
public class MyEdge implements Edge {

    // A List of all the vertices in the edge.
    private ArrayList< Vertex > vertexList;
    // A useful flag for traversal
    private int element;

    /**
     * Default constructor for MyEdge
     */
    public MyEdge( ) {
        vertexList = new ArrayList< Vertex >( );
        element = 0;
    }

    /**
     * Constructor for MyEdge that takes two vertices.
     * 
     * @param v1
     *            The first vertex to be added to the edge
     * @param v2
     *            The second vertex to be added to the edge
     */
    public MyEdge( Vertex v1, Vertex v2 ) {
        // Initialize
        vertexList = new ArrayList< Vertex >( );

        // Add to vertex List
        vertexList.add( v1 );
        vertexList.add( v2 );

        // Set Vertices as adjacent
        v1.adjacentVertices( ).add( v2 );
        v2.adjacentVertices( ).add( v1 );

        // Add the edge to stuff
        v1.incidentEdges( ).add( this );
        v1.incidentEdges( ).add( this );

    }

    /**
     * Getter for 'element'
     * 
     * @return The value of element in the edge
     */
    public int getElement( ) {
        return element;
    }

    /**
     * Setter for 'element'
     * 
     * @param e
     *            The new value for element
     */
    public void setElement( int e ) {
        element = e;
    }

    /**
     * Returns a list of all the vertices in the edge
     * 
     * @return An ArrayList of all the vertices in the edge
     */
    public ArrayList< Vertex > vertices( ) {
        return vertexList;
    }

    /**
     * Returns a String representation of the edge
     * 
     * @return String representing the edge
     */
    public String toString( ) {
        return "<" + vertexList.get( 0 ) + "-" + vertexList.get( 1 ) + ">";
    }

}
