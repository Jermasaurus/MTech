import java.util.ArrayList;

/**
 * Basic Edge functionality for MyGraph based off of Edge.java
 * 
 * @author Jeremy Sommerfeld cs2321 - Fall 2014
 */
public class MyEdge implements Edge {

    private ArrayList< Vertex > vertexList;

    /**
     * Default constructor for MyEdge class
     */
    public MyEdge( ) {
        vertexList = new ArrayList< Vertex >( );
    }

    /**
     * Constructor used to Add new Edges
     * 
     * @param v1
     *            The first Vertex to add
     * @param v2
     *            The second Vertex to add
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
        v2.incidentEdges( ).add( this );
    }

    /**
     * Returns a list of all the vertices connected by this edge.
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
