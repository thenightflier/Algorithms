package com.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by usman on 08/11/2013.
 */
public class GraphTest {

    @Test
    public void testGraph() {
        Graph g = new AdjacencyListGraph(3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        assertEquals(g.getNumberOfVertices(), 3);
        assertEquals(g.getNumberOfEdges(), 2);
        System.out.print(g);

    }
}
