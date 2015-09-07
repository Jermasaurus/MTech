import java.util.ArrayList;

/**
 * Bare bones graph data structure that implements Graph.java
 * 
 * @author Jeremy Sommerfeld cs2321 - Fall 2014
 */
public class MyGraph implements Graph {

    // ArrayLists of all the vertices and edges in the Graph
    private ArrayList< Vertex > vertices;
    private ArrayList< Edge > edges;

    // ArrayList of all the colors used in the graph coloring
    private ArrayList< GraphColor > remainingColors;
    private ArrayList< GraphColor > usedColors;

    /**
     * Default constructor for MyGraph
     */
    public MyGraph( ) {
        // Create new ArrayLists
        vertices = new ArrayList< Vertex >( );
        edges = new ArrayList< Edge >( );
        remainingColors = new ArrayList< GraphColor >( );
        usedColors = new ArrayList< GraphColor >( );
    }

    /**
     * Returns a list of all the vertices in the graph
     * 
     * @return - list of all vertices in the graph
     */
    public ArrayList< Vertex > vertices( ) {
        return vertices;
    }

    /**
     * Adds a Vertex to the graph
     * 
     * @param v
     *            The Vertex to add to the Graph
     * 
     * @return - The vertex added to the graph
     */
    public Vertex addVertex( Vertex v ) {
        vertices.add( v );
        return v;
    }

    /**
     * Removes a Vertex from the graph
     * 
     * @param v
     *            The Vertex to add to the Graph
     * 
     * @return True if the vertex was removed
     */
    public boolean removeVertex( Vertex v ) {
        // If it is unable to find the Vertex v in the list, return false.
        if ( !vertices.remove( v ) ) {
            return false;
        } else {
            // Remove each Edge, and Incident Edge of v until none remain.
            for ( Vertex vertex : vertices ) {
                if ( vertex.adjacentVertices( ).contains( v ) ) {
                    removeEdge( vertex, v );
                    vertex.adjacentVertices( ).remove( v );
                    vertex.incidentEdges( ).remove( v );
                }
            }
            return true;
        }
    }

    /**
     * Returns an ArrayList of all the edges in the graph
     * 
     * @return an ArrayList of all the edges in the graph
     */
    public ArrayList< Edge > edges( ) {
        return edges;
    }

    /**
     * Add an edge to the Graph
     * 
     * @param v1
     *            The first Vertex to add to the edge
     * @param v2
     *            The second Vertex to add to the edge
     * 
     * @return the Edge added to the Graph
     */
    public Edge addEdge( Vertex v1, Vertex v2 ) {
        // Self loops are not allowed, so return null
        if ( v1 == v2 ) {
            return null;
        }
        // Create an edge out of the vertices and add it
        Edge e = new MyEdge( v1, v2 );
        return addEdge( e );
    }

    /**
     * Add an edge to the Graph
     * 
     * @param e
     *            the Edge to add to the graph
     * 
     * @return the Edge added to the Graph
     */
    public Edge addEdge( Edge e ) {
        // Simply add the edge to the list
        edges.add( e );
        return e;
    }

    /**
     * Remove an edge from the Graph
     * 
     * @param v1
     *            The first Vertex to remove from an edge
     * @param v2
     *            The second Vertex to remove from an edge
     * 
     * @return True if the Edge was successfully removed
     */
    public boolean removeEdge( Vertex v1, Vertex v2 ) {
        for ( Edge edge : edges ) {
            if ( edge.vertices( ).contains( v1 ) && edge.vertices( ).contains( v2 ) ) {
                edges.remove( edge );

                // Remove Incident Edges
                v1.incidentEdges( ).remove( edge );
                v2.incidentEdges( ).remove( edge );

                // Update, so edges are no longer adjacent
                v1.adjacentVertices( ).remove( v2 );
                v2.adjacentVertices( ).remove( v1 );

                return true;
            }
        }
        return false;
    }

    /**
     * Remove an edge from the Graph
     * 
     * @param e
     *            the edge to remove from the graph
     * 
     * @return True if the Edge was successfully removed
     */
    public boolean removeEdge( Edge e ) {
        return removeEdge( e.vertices( ).get( 0 ), e.vertices( ).get( 1 ) );
    }

    /**
     * Find an Edge in the Graph by its vertices
     * 
     * @param v1
     *            the first vertex to check with
     * @param v2
     *            the second vertex to check with
     * 
     * @return the edge that was found
     */
    public Edge findEdge( Vertex v1, Vertex v2 ) {
        for ( Edge edge : edges ) {
            if ( edge.vertices( ).contains( v1 ) && edge.vertices( ).contains( v2 ) ) {
                return edge;
            }
        }
        return null;
    }

    /**
     * Find whether or not two vertices are connected
     * 
     * @param v1
     *            the first vertex to check with
     * @param v2
     *            the second vertex to check with
     * 
     * @return True if the vertices are connected.
     */
    public boolean areConnected( Vertex v1, Vertex v2 ) {
        if ( findEdge( v1, v2 ) == null ) {
            return false;
        }
        return true;
    }

    /**
     * Return an ArrayList of all the vertices that are adjacent to v1
     * 
     * @param v1
     *            the vertex to find the adjacent vertices to
     * 
     * @return ArrayList of adjacent vertices to v1
     */
    public ArrayList< Vertex > adjacentVertices( Vertex v1 ) {
        return v1.adjacentVertices( );
    }

    /**
     * Return an ArrayList of all the incident edges of v1
     * 
     * @param v1
     *            the vertex to find the incident edges of
     * 
     * @return ArrayList of incident edges of v1
     */
    public ArrayList< Edge > incidentEdges( Vertex v1 ) {
        return v1.incidentEdges( );
    }

    /**
     * Colors the graph based off of an ArrayList of colors
     * 
     * @param colors
     *            the colors to color with
     * 
     * @return the number of colors used
     */
    public int colorGraph( ArrayList< GraphColor > colors ) {
        for ( Vertex vertex : vertices ) {
            // Vertex has not been colored
            remainingColors.clear( );
            remainingColors.addAll( colors );
            for ( Vertex adjacent : vertex.adjacentVertices( ) ) {
                // If adjacent Vertex has a color, remove it from the available
                // colors
                remainingColors.remove( adjacent.getColor( ) );
            }

            // If there are no longer any colors left, return -1
            if ( remainingColors.size( ) == 0 ) {
                return -1;
            }

            // Color the Vertex
            vertex.setColor( remainingColors.get( 0 ) );
            if ( !usedColors.contains( remainingColors.get( 0 ) ) ) {
                usedColors.add( remainingColors.get( 0 ) );
            }
        }
        return usedColors.size( );
    }

    /**
     * Returns a String representation of the given Graph
     * 
     * @return String representing the graph
     */
    public String toString( ) {
        String tempString = "<Graph:[";

        // Add in Vertex:COLOR
        for ( int i = 0; i < vertices.size( ) - 1; i++ ) {
            tempString = tempString.concat( "<" + vertices.get( i ) + ":" + vertices.get( i ).getColor( ) + ">, " );
        }
        tempString = tempString.concat( "<" + vertices.get( vertices.size( ) - 1 ) + ":"
                + vertices.get( vertices.size( ) - 1 ).getColor( ) + ">], [" );

        // Add in Edge: Vertex - Vertex
        for ( int i = 0; i < edges.size( ) - 1; i++ ) {
            tempString = tempString.concat( edges.get( i ).toString( ) + ", " );
        }
        tempString = tempString.concat( edges.get( edges.size( ) - 1 ).toString( ) + "]>" );

        return tempString;
    }

}
