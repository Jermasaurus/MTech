import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * A simple JUnit test case for the MyMaze class.
 * 
 * @author Jeremy Sommerfeld, Ethan Koeppe cs2321 - Fall 2014
 */
public class MyMazeTest {

    /**
     * Sample testing method
     */
    public void test( ) {
        MyMaze maze = new MyMaze( );
        maze.generateMaze( 5, 5 );
        System.out.println( "startVertext( ): " + maze.startVertex( ) );
        System.out.println( "finishVertext( ): " + maze.finishVertex( ) );
        System.out.println( "solveMaze( ): " + maze.solveMaze( ) );
        System.out.println( "maze.toString( ):\n" + maze );
    }

    // MyPair Test
    @Test
    public void myPairTest( ) {
        MyPair pair = new MyPair( );
        if ( pair.getX( ) != 0 || pair.getY( ) != 0 ) {
            fail( "Pair not initialized properly. Should be set to (0, 0) initially." );
        }
        pair.setX( 1 );
        pair.setY( 2 );
        if ( pair.getX( ) != 1 || pair.getY( ) != 2 ) {
            fail( "Setter methods for MyPair not implemented properly." );
        }
    }

    // MyVertex Test
    @Test
    public void myVertexTest( ) {
        MyVertex vertex = new MyVertex( );
        if ( vertex.getElement( ) == null ) {
            fail( "Pair inside vertex not initialized properly." );
        }
        if ( vertex.incidentEdges( ).size( ) != 0 ) {
            fail( "Size of edges using default constructor is incorrect." );
        }
        if ( vertex.adjacentVertices( ).size( ) != 0 ) {
            fail( "Size of adjacent vertices using default constructor is incorrect." );
        }
        MyPair pair = new MyPair( );
        pair.setX( 1 );
        pair.setY( 1 );
        vertex.setElement( pair );
        if ( vertex.getElement( ).getX( ) != 1 || vertex.getElement( ).getY( ) != 1 ) {
            fail( "Coordinates for vertex not gathered from pair properly." );
        }
    }

    // MyEdge Test
    @Test
    public void myEdgeTest( ) {
        MyEdge edge = new MyEdge( );
        if ( edge.vertices( ).size( ) != 0 ) {
            fail( "Size of contained vertices using default constructor is incorrect." );
        }
        edge.setElement( 2 );
        if ( edge.getElement( ) != 2 ) {
            fail( "Getter / Setter for element not implemented properly." );
        }
    }

    // MyGraph Tests
    @Test
    public void removeVertexAndEdgesTest( ) {
        MyGraph mygraph = new MyGraph( );
        MyVertex v0 = new MyVertex( );
        MyVertex v1 = new MyVertex( );
        MyVertex v2 = new MyVertex( );
        mygraph.addVertex( v0 );
        mygraph.addVertex( v1 );
        mygraph.addVertex( v2 );
        mygraph.addEdge( v0, v1 );
        mygraph.addEdge( v1, v2 );
        mygraph.addEdge( v2, v0 );
        mygraph.removeVertex( v2 );
        int numVertices = mygraph.vertices( ).size( );
        int numEdges = mygraph.edges( ).size( );
        if ( numVertices != 2 || numEdges != 1 ) {
            fail( "Added 3 vertices and 3 edges, removed 1 vertext and should only have 1 edge remaining but graph = "
                    + mygraph );
        }
    }

    @Test
    public void removeVertexTestbyNumberOfVertices( ) {
        MyGraph mygraph = new MyGraph( );
        MyVertex v0 = new MyVertex( );
        MyVertex v1 = new MyVertex( );
        MyVertex v2 = new MyVertex( );
        mygraph.addVertex( v0 );
        mygraph.addVertex( v1 );
        mygraph.addVertex( v2 );
        mygraph.removeVertex( v0 );
        mygraph.removeVertex( v2 );
        int numVertices = mygraph.vertices( ).size( );
        if ( numVertices != 1 ) {
            fail( "Added 3 vertices, removed 2 but graph = " + mygraph );
        }
    }

    @Test
    public void removeVertexTestbyContains( ) {
        MyGraph mygraph = new MyGraph( );
        ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
        for ( int i = 0; i < 100; i++ ) {
            myvertices.add( mygraph.addVertex( new MyVertex( ) ) );
        }
        for ( int i = 0; i < 30; i++ ) {
            Vertex v = myvertices.get( i * 2 );
            mygraph.removeVertex( v );
            myvertices.remove( v );
        }
        boolean itWorks = true;
        for ( Vertex v : mygraph.vertices( ) ) {
            itWorks = itWorks && myvertices.contains( v );
        }
        if ( !itWorks ) {
            fail( "Added 100 vertices, removed 30, but did not find them all remaining in the graph " + mygraph );
        }
        if ( myvertices.size( ) != mygraph.vertices( ).size( ) ) {
            fail( "Added 100 vertices, removed 30, graph vertices was not the same size " + mygraph );
        }
    }

    @Test
    public void addVertexTestbyContains( ) {
        MyGraph mygraph = new MyGraph( );
        ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
        for ( int i = 0; i < 100; i++ ) {
            myvertices.add( mygraph.addVertex( new MyVertex( ) ) );
        }
        boolean itWorks = true;
        for ( Vertex v : mygraph.vertices( ) ) {
            itWorks = itWorks && myvertices.contains( v );
        }
        if ( !itWorks ) {
            fail( "Added 100 vertices but did not find them all in the graph " + mygraph );
        }
        if ( myvertices.size( ) != mygraph.vertices( ).size( ) ) {
            fail( "Added 100 vertices graph vertices was not the same size " + mygraph );
        }
    }

    @Test
    public void addVertexTestbyNumberOfVertices( ) {
        MyGraph mygraph = new MyGraph( );
        MyVertex v0 = new MyVertex( );
        MyVertex v1 = new MyVertex( );
        MyVertex v2 = new MyVertex( );
        mygraph.addVertex( v0 );
        mygraph.addVertex( v1 );
        mygraph.addVertex( v2 );
        int numVertices = mygraph.vertices( ).size( );
        if ( numVertices != 3 ) {
            fail( "Added 3 vertices but graph = " + mygraph );
        }
    }

    @Test
    public void removeEdgeTestbyNumberOfEdges( ) {
        MyGraph mygraph = new MyGraph( );
        MyVertex v0 = new MyVertex( );
        MyVertex v1 = new MyVertex( );
        MyVertex v2 = new MyVertex( );
        mygraph.addVertex( v0 );
        mygraph.addVertex( v1 );
        mygraph.addVertex( v2 );
        Edge e0 = mygraph.addEdge( v0, v1 );
        mygraph.addEdge( v1, v2 );
        Edge e2 = mygraph.addEdge( v2, v0 );
        mygraph.removeEdge( e0 );
        mygraph.removeEdge( e2 );
        int numEdges = mygraph.edges( ).size( );
        if ( numEdges != 1 ) {
            fail( "Added 3 edges, removed 2 but graph = " + mygraph );
        }
    }

    @Test
    public void addEdgeTestbyNumberOfEdges( ) {
        MyGraph mygraph = new MyGraph( );
        MyVertex v0 = new MyVertex( );
        MyVertex v1 = new MyVertex( );
        MyVertex v2 = new MyVertex( );
        mygraph.addVertex( v0 );
        mygraph.addVertex( v1 );
        mygraph.addVertex( v2 );
        mygraph.addEdge( v0, v1 );
        mygraph.addEdge( v1, v2 );
        mygraph.addEdge( v2, v0 );
        int numEdges = mygraph.edges( ).size( );
        if ( numEdges != 3 ) {
            fail( "Added 3 edges but graph = " + mygraph );
        }
    }

    @Test
    public void edgeLoopTest( ) {
        MyGraph mygraph = new MyGraph( );
        ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
        myvertices.add( mygraph.addVertex( new MyVertex( ) ) );

        if ( mygraph.addEdge( myvertices.get( 0 ), myvertices.get( 0 ) ) != null ) {
            fail( "Tried to add an edge loop and did not return null" );
        }
    }

    @Test
    public void testNumberOfEdges( ) {
        MyMaze maze = new MyMaze( );
        maze.generateMaze( 5, 5 );
        Graph graph = maze.toGraph( );
        if ( graph.edges( ).size( ) != graph.vertices( ).size( ) - 1 ) {
            fail( "For a 5 x 5 maze, there should be 24 edges. Instead, there are " + graph.edges( ).size( )
                    + " edges." );
        }
    }

    @Test
    public void testDistinctStartFinish( ) {
        MyMaze maze1 = new MyMaze( );
        maze1.generateMaze( 5, 5 );
        if ( maze1.startVertex( ) == maze1.finishVertex( ) ) {
            fail( "startVertex and finishVertex are not unique." );
        }

        MyMaze maze2 = new MyMaze( );
        maze2.generateMaze( 10, 10 );
        if ( maze2.startVertex( ) == maze2.finishVertex( ) ) {
            fail( "startVertex and finishVertex are not unique." );
        }

        MyMaze maze3 = new MyMaze( );
        maze3.generateMaze( 15, 15 );
        if ( maze3.startVertex( ) == maze3.finishVertex( ) ) {
            fail( "startVertex and finishVertex are not unique." );
        }

        MyMaze maze4 = new MyMaze( );
        maze4.generateMaze( 5, 15 );
        if ( maze4.startVertex( ) == maze4.finishVertex( ) ) {
            fail( "startVertex and finishVertex are not unique." );
        }
    }

    @Test
    public void testArrayIsCorrectSize( ) {
        MyMaze maze = new MyMaze( );
        maze.generateMaze( 5, 5 );
        Vertex[ ][ ] mazeArray = maze.toArray( );
        if ( mazeArray.length != 5 || mazeArray[0].length != 5 ) {
            fail( "Maze array is not 5 x 5." );
        }

        MyMaze maze2 = new MyMaze( );
        maze2.generateMaze( 10, 0 );
        Vertex[ ][ ] mazeArray2 = maze2.toArray( );
        if ( mazeArray2.length != 0 ) {
            fail( "Maze array is not empty." );
        }

        MyMaze maze3 = new MyMaze( );
        maze3.generateMaze( 1, 1 );
        Vertex[ ][ ] mazeArray3 = maze3.toArray( );
        if ( mazeArray3.length != 1 || mazeArray3[0].length != 1 ) {
            fail( "Maze array is not 1 x 1." );
        }
    }

    @Test
    public void testToGraph( ) {
        MyMaze maze = new MyMaze( );
        maze.generateMaze( 5, 5 );
        if ( maze.toGraph( ).vertices( ).size( ) != 25 ) {
            fail( "Wrong number of vertices in graph." );
        }
        if ( maze.toGraph( ).edges( ).size( ) != 24 ) {
            fail( "Wrong number of edges in graph." );
        }
    }

    @Test
    public void testPathBetweenAllVertices( ) {
        MyMaze maze = new MyMaze( );
        maze.generateMaze( 4, 4 );
        Graph graph = maze.toGraph( );
        ArrayList< Vertex > vertices = graph.vertices( );
        for ( int i = 0; i < vertices.size( ); i++ ) {
            for ( int j = 0; j < vertices.size( ); j++ ) {
                Vertex v1 = vertices.get( i );
                Vertex v2 = vertices.get( j );
                if ( v1 != v2 ) {
                    if ( graph.shortestPath( (MyVertex) v1, (MyVertex) v2 ).isEmpty( ) ) {
                        fail( "Vertex " + v1 + " is not connected to vertex " + v2 + " in graph:" + graph );
                    }
                }
            }
        }
    }

    @Test
    public void testSolutionPath( ) {
        MyMaze maze = new MyMaze( );
        maze.generateMaze( 4, 4 );
        Graph graph = maze.toGraph( );
        ArrayList< Vertex > path = graph.shortestPath( maze.startVertex( ), maze.finishVertex( ) );
        ArrayList< Vertex > solve = maze.solveMaze( );
        if ( path.size( ) != solve.size( ) ) {
            fail( "Path between start and finish differs in size from solution path." );
        }
        for ( Vertex v : path ) {
            if ( !solve.contains( v ) ) {
                fail( "Vertex " + v + " not found in solution: " + solve );
            }
        }
    }

}