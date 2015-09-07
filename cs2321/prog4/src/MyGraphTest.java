import static org.junit.Assert.*;

import java.security.SecureRandom;
import java.util.ArrayList;

import org.junit.Test;

public class MyGraphTest {

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
    public void colorGraphTestUsesSomeColors( ) {
        ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
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
        int numColors = mygraph.colorGraph( colors );
        if ( numColors > 3 ) {
            fail( "colorGraph( " + colors + " ) expected = 3, returned = " + numColors + " for " + mygraph );
        }
    }

    @Test
    public void colorGraphTestUsesAllColors( ) {
        ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
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
        int numColors = mygraph.colorGraph( colors );
        if ( numColors != 3 ) {
            fail( "colorGraph( " + colors + " ) expected = 3 returned = " + numColors + " for " + mygraph );
        }
    }

    private static final SecureRandom random = new SecureRandom( );

    public static < T extends Enum< ? >> T randomEnum( Class< T > clazz ) {
        int x = random.nextInt( clazz.getEnumConstants( ).length );
        return clazz.getEnumConstants( )[x];
    }

    public boolean addNewColor( ArrayList< GraphColor > list, GraphColor c ) {
        boolean result = false;
        if ( !list.contains( c ) ) {
            result = true;
            list.add( c );
        }
        return result;
    }

    @Test
    public void colorGraphTestCannotColor( ) {
        ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
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
        int numColors = mygraph.colorGraph( colors );
        if ( numColors != -1 ) {
            fail( "colorGraph( " + colors + " ) expected=-1 returned=" + numColors + " for " + mygraph );
        }
    }

    @Test
    public void removeVertexGraphColorTestbyContains( ) {
        MyGraph mygraph = new MyGraph( );
        ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
        ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        for ( int i = 0; i < 100; i++ ) {
            myvertices.add( mygraph.addVertex( new MyVertex( ) ) );
            if ( i > 0 ) {
                mygraph.addEdge( myvertices.get( i - 1 ), myvertices.get( i ) );
            }
        }
        for ( int i = 0; i < 30; i++ ) {
            Vertex v = myvertices.get( i * 2 );
            mygraph.removeVertex( v );
            myvertices.remove( v );
        }
        mygraph.colorGraph( colors );
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
    public void edgeLoopTest( ) {
        MyGraph mygraph = new MyGraph( );
        ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
        myvertices.add( mygraph.addVertex( new MyVertex( ) ) );

        if ( mygraph.addEdge( myvertices.get( 0 ), myvertices.get( 0 ) ) != null ) {
            fail( "Tried to add an edge loop and did not return null" );
        }
    }

    @Test
    public void toStringTests( ) {
        String test = "<Graph:[<v322:WHITE>, <v323:RED>, <v324:BLUE>], [<v322-v323>, <v323-v324>, <v324-v322>]>";
        ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
        while ( !addNewColor( colors, randomEnum( GraphColor.class ) ) );
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
        mygraph.colorGraph( colors );
        if ( mygraph.toString( ).equals( test ) ) {
            fail( "To string error!!" );
        }
    }

}