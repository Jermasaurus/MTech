import java.util.ArrayList;

/**
 * This class implements a graph based off of the interface in Graph.java
 * 
 * @author Jeremy Sommerfeld, Ethan Koeppe cs2321 - Fall 2014
 */
public class MyGraph implements Graph {

    // An ArrayList of all the vertices in the Graph
    private ArrayList< Vertex > vertices;
    // An ArrayList of all the edges in the Graph
    private ArrayList< Edge > edges;

    /**
     * Default constructor for MyGraph
     */
    public MyGraph( ) {
        vertices = new ArrayList< Vertex >( );
        edges = new ArrayList< Edge >( );
    }

    /**
     * Returns a list of all the vertices in the graph
     * 
     * @return an ArrayList of all vertices in the graph
     */
    public ArrayList< Vertex > vertices( ) {
        return vertices;
    }

    /**
     * Adds a vertex to the graph
     * 
     * @param p
     *            The pair of coordinates associated with the new vertex
     * 
     * @return the vertex added to the graph
     */
    public Vertex addVertex( Pair p ) {
        // Temporary vertex used for adding the Pair p
        Vertex tempVertex = new MyVertex( );
        tempVertex.setElement( p );

        return addVertex( tempVertex );
    }

    /**
     * Adds a vertex to the graph
     * 
     * @param v
     *            the vertex to add
     * 
     * @return the vertex added to the graph
     */
    public Vertex addVertex( Vertex v ) {
        vertices.add( v );
        return v;
    }

    /**
     * Removes a vertex from the graph
     * 
     * @param p
     *            the pair to remove
     * 
     * @return true if the removal is successful, false otherwise
     */
    public boolean removeVertex( Pair p ) {
        // Temporary vertex used as a helper to remove Pair p
        Vertex tempVertex = new MyVertex( );
        tempVertex.setElement( p );

        // Call other removeVertex method and return its result
        return removeVertex( tempVertex );
    }

    /**
     * Removes a vertex from the graph
     * 
     * @param v
     *            the vertex to remove
     * 
     * @return true if the removal is successful, false otherwise
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
     * Find a vertex in the graph based off of its element
     * 
     * @param p
     *            The pair to search the graph for
     * 
     * @return the Vertex that was found
     */
    public Vertex findVertex( Pair p ) {
        // For each Vertex in vertices:
        for ( Vertex vertex : vertices ) {
            // If the Vertex matches the x and y values passed: return it
            if ( vertex.getElement( ).getX( ) == p.getX( ) && vertex.getElement( ).getY( ) == p.getY( ) ) {
                return vertex;
            }
        }
        // Else, if nothing is found, return null
        return null;
    }

    /**
     * Returns a list of all the edges in the graph
     * 
     * @return - list of all edges in the graph
     */
    public ArrayList< Edge > edges( ) {
        return edges;
    }

    /**
     * Adds an edge to the graph
     * 
     * @param v1
     *            the first vertex in the edge
     * @param v2
     *            the second vertex in the edge
     * 
     * @return the edge added to the graph
     */
    public Edge addEdge( Vertex v1, Vertex v2 ) {
        // Look for edge loops
        if ( v1 == v2 ) {
            return null;
        }
        MyEdge e = new MyEdge( v1, v2 );
        // Call other addEdge method and return its result
        return addEdge( e );
    }

    /**
     * Add an edge to the graph
     * 
     * @param e
     *            the edge to be added
     * 
     * @return the edge that was added
     */
    public Edge addEdge( Edge e ) {
        edges.add( e );
        return e;
    }

    /**
     * Removes an Edge from the Graph
     * 
     * @param v1
     *            The first vertex in the edge to remove
     * @param v2
     *            The second vertex in the edge to remove
     * 
     * @return True if the removal was successful, false otherwise
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
     * Removes an Edge from the Graph
     * 
     * @param e
     *            The edge to remove from the graph
     * 
     * @return True if the removal was successful, false otherwise
     */
    public boolean removeEdge( Edge e ) {
        return removeEdge( e.vertices( ).get( 0 ), e.vertices( ).get( 1 ) );
    }

    /**
     * Finds an edge in the graph based on two vertices
     * 
     * @param v1
     *            The first vertex to check with
     * @param v2
     *            The second vertex to check with
     * 
     * @return The edge that connects vertices v1 and v2
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
     * Finds whether or not two vertices are connected
     * 
     * @param v1
     *            The first vertex to check with
     * @param v2
     *            The second vertex to check with
     * 
     * @return True if the vertices are connected, false otherwise
     */
    public boolean areConnected( Vertex v1, Vertex v2 ) {
        if ( findEdge( v1, v2 ) == null ) {
            return false;
        }
        return true;
    }

    /**
     * Finds all of the adjacent vertices to the vertex passed in
     * 
     * @param v1
     *            The vertex to find vertices adjacent to
     * 
     * @return An ArrayList of all the adjacent vertices to v1
     */
    public ArrayList< Vertex > adjacentVertices( Vertex v1 ) {
        return v1.adjacentVertices( );
    }

    /**
     * Finds all of the incident edges to the vertex passed in
     * 
     * @param v1
     *            The vertex to find the incident edges of
     * 
     * @return An ArrayList of all the incident edges of v1
     */
    public ArrayList< Edge > incidentEdges( Vertex v1 ) {
        return v1.incidentEdges( );
    }

    /**
     * Finds the shortest path between two vertices
     * 
     * @param v1
     *            The first vertex to search between
     * @param v2
     *            The second vertex to search between
     * 
     * @return An ArrayList of all the vertices along the shortest path between v1 and v2
     */
    public ArrayList< Vertex > shortestPath( Vertex v1, Vertex v2 ) {

        ArrayList< Vertex > list = new ArrayList< Vertex >( );
        ArrayList< Vertex > visited = new ArrayList< Vertex >( );

        list.add( v1 );
        visited.add( v1 );

        return traversal( v1, v2, list, visited );
    }

    /**
     * A traversal helper method for the shortestPath method. It searches the tree recursively for a
     * path between v1 and v2
     * 
     * @param v1
     *            The starting vertex to search with
     * @param v2
     *            The ending vertex to search with
     * @param list
     *            An ArrayList of all the vertices visited in the traversal
     * @param visited
     *            An ArrayList of all the nodes that have been visited in the traversal so far
     * 
     * @return An ArrayList of all the vertices along the path from v1 to v2
     */
    public ArrayList< Vertex > traversal( Vertex v1, Vertex v2, ArrayList< Vertex > list, ArrayList< Vertex > visited ) {
        // Base case, we've found the end value.
        if ( v1.getElement( ).getX( ) == v2.getElement( ).getX( )
                && v1.getElement( ).getY( ) == v2.getElement( ).getY( ) ) {
            return list;
        }

        else {
            for ( Vertex vertex : v1.adjacentVertices( ) ) {
                if ( !visited.contains( vertex ) ) {
                    list.add( vertex );
                    visited.add( vertex );
                    return traversal( vertex, v2, list, visited );
                }
            }
            list.remove( v1 );
            return traversal( list.get( list.size( ) - 1 ), v2, list, visited );
        }

    }

    /**
     * Creates a randomly distributed minimum spanning tree using the graph in this class
     * 
     * @return A graph containing the minimum spanning tree of this graph
     */
    public Graph minimumSpanningTree( ) {
        // Create a temporary list of all the edges in the graph
        ArrayList< Edge > tempEdges = new ArrayList< Edge >( );
        tempEdges.addAll( edges );

        // Create in and outLists
        ArrayList< Vertex > inList = new ArrayList< Vertex >( );
        ArrayList< Vertex > outList = new ArrayList< Vertex >( );
        outList.addAll( vertices );

        // Find a random first vertex to start with
        inList.add( outList.remove( (int) ( Math.random( ) * outList.size( ) ) ) );
        // System.out.println( "inlist = " + inList.get( 0 ) );

        int index = 0;
        while ( outList.size( ) > 0 ) {
            // Choose a random edge in the list of edges
            index = (int) ( Math.random( ) * tempEdges.size( ) );
            Edge randomEdge = tempEdges.get( index );

            // Only add the edge to the spanning tree if both vertices are applicable
            if ( inList.contains( randomEdge.vertices( ).get( 0 ) )
                    && outList.contains( randomEdge.vertices( ).get( 1 ) ) ) {
                inList.add( randomEdge.vertices( ).get( 1 ) );
                outList.remove( randomEdge.vertices( ).get( 1 ) );
                // Set a marker to note it is in the minimum spanning tree
                randomEdge.setElement( 1 );
                tempEdges.remove( index );
            }
            if ( inList.contains( randomEdge.vertices( ).get( 1 ) )
                    && outList.contains( randomEdge.vertices( ).get( 0 ) ) ) {
                inList.add( randomEdge.vertices( ).get( 0 ) );
                outList.remove( randomEdge.vertices( ).get( 0 ) );
                // Set a marker to note it is in the minimum spanning tree
                randomEdge.setElement( 1 );
                tempEdges.remove( index );
            }
        }

        // Check all the edges in the graph for markers, if they are not set, remove them from the
        // graph
        for ( int i = 0; i < edges.size( ); i++ ) {
            if ( edges.get( i ).getElement( ) == 0 ) {
                removeEdge( edges.get( i ) );
                i--;
            }
        }

        // Return the new graph
        return this;
    }

    /**
     * Creates a String representation of the Graph
     * 
     * @return A String representation of the graph
     */
    public String toString( ) {
        String tempString = "<Graph:[";

        for ( int i = 0; i < edges.size( ) - 1; i++ ) {
            tempString = tempString.concat( edges.get( i ).toString( ) + ", " );
        }
        if ( vertices.size( ) <= 1 ) {
            // tempString = tempString.concat( edges.get( edges.size( ) ).toString( ) );
        } else {
            tempString = tempString.concat( edges.get( edges.size( ) - 1 ).toString( ) );
        }
        tempString = tempString.concat( "]>" );

        return tempString;
    }
}
