import java.util.ArrayList;

/**
 * Basic functionality for a maze implementation. Can generate and solve mazes. Based off of the
 * interface provided in Maze.java
 * 
 * @author Jeremy Sommerfeld, Ethan Koeppe cs2321 - Fall 2014
 */
public class MyMaze implements Maze {
    // Create a new graph for the maze to use
    private Graph mazeGraph = new MyGraph( );
    // Create a 2D array to be used in the maze
    private Vertex[ ][ ] mazeArray;
    // Create the starting and ending vertices
    private Vertex startVertex;
    private Vertex finishVertex;

    /**
     * Default constructor for MyMaze
     */
    public MyMaze( ) {
        mazeGraph = new MyGraph( );
    }

    /**
     * Generates a maze with the given rows and columns
     * 
     * @param rows
     *            The number of rows the maze will have
     * @param columns
     *            The number of columns the maze will have
     */
    public void generateMaze( int rows, int columns ) {
        // Check to see if rows or columns are invalid
        if ( rows < 1 || columns < 1 ) {
            startVertex = null;
            finishVertex = null;

            // Add every Vertex into the graph
            mazeArray = new Vertex[ 0 ][ 0 ];

            return;
        } else if ( rows == 1 && columns == 1 ) {
            // startVertex = null;
            // finishVertex = null;

            mazeArray = new Vertex[ 1 ][ 1 ];

            Pair tempPair = new MyPair( );

            tempPair.setX( 0 );
            tempPair.setY( 0 );

            mazeArray[0][0] = mazeGraph.addVertex( tempPair );

            startVertex = mazeArray[0][0];
            finishVertex = mazeArray[0][0];

            return;
        }

        // Add every Vertex into the graph
        mazeArray = new Vertex[ rows ][ columns ];

        Pair tempPair = new MyPair( );
        for ( int row = 0; row < rows; row++ ) {
            for ( int column = 0; column < columns; column++ ) {

                tempPair.setX( row );
                tempPair.setY( column );

                mazeArray[row][column] = mazeGraph.addVertex( tempPair );
            }
        }

        // Connect adjacent vertices with edges.
        for ( int row = 0; row < rows; row++ ) {
            for ( int column = 0; column < columns; column++ ) {
                if ( row != 0 ) {
                    mazeGraph.addEdge( mazeArray[row][column], mazeArray[row - 1][column] );
                }
                if ( column != 0 ) {
                    mazeGraph.addEdge( mazeArray[row][column], mazeArray[row][column - 1] );
                }
            }
        }

        // Set the starting and ending vertices randomly
        startVertex = mazeArray[(int) ( Math.random( ) * rows )][(int) ( Math.random( ) * columns )];
        finishVertex = mazeArray[(int) ( Math.random( ) * rows )][(int) ( Math.random( ) * columns )];
        while ( startVertex == finishVertex ) {
            finishVertex = mazeArray[(int) ( Math.random( ) * rows )][(int) ( Math.random( ) * columns )];
        }

        // Randomly make a maze
        mazeGraph = mazeGraph.minimumSpanningTree( );
    }

    /**
     * Solves the maze based on finding the shortest path between the start and finish vertex.
     * 
     * @return An ArrayList of all the vertices traversed from start to finish
     */
    public ArrayList< Vertex > solveMaze( ) {
        if ( mazeGraph.vertices( ).size( ) == 0 ) {
            return new ArrayList< Vertex >( );
        }
        return mazeGraph.shortestPath( startVertex, finishVertex );
    }

    /**
     * Returns a representation of the maze in Graph form
     * 
     * @return A Graph of the maze
     */
    public Graph toGraph( ) {
        return mazeGraph;
    }

    /**
     * Returns a representation of the maze in 2D array form
     * 
     * @return A 2D array of the maze
     */
    public Vertex[ ][ ] toArray( ) {
        return mazeArray;
    }

    /**
     * Returns the starting vertex of the maze
     * 
     * @return The start Vertex for the maze
     */
    public Vertex startVertex( ) {
        return startVertex;
    }

    /**
     * Returns the ending vertex of the maze
     * 
     * @return The finish Vertex for the maze
     */
    public Vertex finishVertex( ) {
        return finishVertex;
    }

    /**
     * Creates a String representation of the Maze
     * 
     * @return A String representation of the Maze
     */
    public String toString( ) {
        // Check if Graph has been generated properly
        if ( mazeArray.length < 1 ) {
            return "";
        }

        int rows = mazeArray.length;
        int columns = mazeArray[0].length;

        ArrayList< Vertex > solution = solveMaze( );
        String strGraph = "";
        String inBetween = "";

        // Draw Graph
        for ( int row = 0; row < rows; row++ ) {
            for ( int column = 0; column < columns; column++ ) {
                // Check to see if it is a vertex and add it in
                if ( mazeArray[row][column] == startVertex ) {
                    strGraph = strGraph.concat( "S" );
                } else if ( mazeArray[row][column] == finishVertex ) {
                    strGraph = strGraph.concat( "F" );
                } else if ( solution.contains( mazeArray[row][column] ) ) {
                    strGraph = strGraph.concat( "o" );
                } else {
                    strGraph = strGraph.concat( "•" );
                }

                // Check to see if there are edges and add them in
                if ( column != columns - 1 ) {
                    if ( mazeArray[row][column].adjacentVertices( ).contains( mazeArray[row][column + 1] ) ) {
                        if ( solution.contains( mazeArray[row][column] )
                                && solution.contains( mazeArray[row][column + 1] ) ) {
                            strGraph = strGraph.concat( "==" );
                        } else {
                            strGraph = strGraph.concat( "--" );
                        }
                    } else {
                        strGraph = strGraph.concat( "  " );
                    }
                }
                if ( row != rows - 1 ) {
                    if ( mazeArray[row][column].adjacentVertices( ).contains( mazeArray[row + 1][column] ) ) {
                        if ( solution.contains( mazeArray[row][column] )
                                && solution.contains( mazeArray[row + 1][column] ) ) {
                            // What is this symbol? It makes our toString shift off
                            inBetween = inBetween.concat( "!  " );
                        } else {
                            inBetween = inBetween.concat( "|  " );
                        }
                    } else {
                        inBetween = inBetween.concat( "   " );
                    }
                }
            }
            if ( row != rows - 1 ) {
                strGraph = strGraph.concat( "\n" );
                strGraph = strGraph.concat( inBetween + "\n" );
            }
            inBetween = "";
        }
        return strGraph;
    }
}
