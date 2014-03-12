package com.graph;

import com.graph.AdjacencyListGraph;
import com.graph.Graph;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by usman on 08/11/2013.
 */
public class GraphTest {

    @Test
    public void testGraph(){
        Graph g = new AdjacencyListGraph(3);
        g.addEdge(0,1);
        g.addEdge(0,2);
        assertEquals(g.getNumberOfVertices(), 3);
        assertEquals(g.getNumberOfEdges(),2);
        System.out.print(g);

    }
}
