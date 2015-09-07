import java.util.ArrayList;

/**
 * Basic Vertex functionality for MyGraph based off of Vertex.java
 * 
 * @author Jeremy Sommerfeld cs2321 - Fall 2014
 */
public class MyVertex implements Vertex {
    // Simple counter and ID to be given to Vertices
    private static int count = 0;
    private int id;

    // Color of Vertex
    private GraphColor color;

    // ArrayLists of Edges and Adjacent Vertices
    private ArrayList< Edge > incidentEdges;
    private ArrayList< Vertex > adjacentVertices;

    /**
     * Default constructor for the MyVertex class
     */
    public MyVertex( ) {
        // Set ID and increment so next Vertex count++
        id = count;
        count++;

        // Set color to NULL initially
        color = null;

        // Create new Lists
        incidentEdges = new ArrayList< Edge >( );
        adjacentVertices = new ArrayList< Vertex >( );
    }

    /**
     * Returns the unique ID of the Vertex
     * 
     * @return The ID of the vertex
     */
    public int getId( ) {
        return id;
    }

    /**
     * Returns the color of the Vertex
     * 
     * @return The color of the Vertex
     */
    public GraphColor getColor( ) {
        return color;
    }

    /**
     * Sets the color of the Vertex
     * 
     * @param newVal
     *            the new color value
     */
    public void setColor( GraphColor newVal ) {
        color = newVal;
    }

    /**
     * Returns a list of all the incident Edges
     * 
     * @return An ArrayLIst of all the incident edges
     */
    public ArrayList< Edge > incidentEdges( ) {
        return incidentEdges;
    }

    /**
     * Returns a list of all the adjacent vertices
     * 
     * @return - An ArrayList of all the adjacent vertices
     */
    public ArrayList< Vertex > adjacentVertices( ) {
        return adjacentVertices;
    }

    /**
     * Returns a String representation of the vertex
     * 
     * @return - String representing the vertex
     */
    public String toString( ) {
        return "v" + id;
    }

}
