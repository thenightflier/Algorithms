package com.graph.search;

import com.graph.AdjacencyListGraph;
import com.graph.Graph;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by usman on 08/11/2013.
 */
public class SearchTest {

    @Test
    public void testDFS() {
        Graph g = new AdjacencyListGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
        assertTrue(dfs.isConnected(3));
        assertFalse(dfs.isConnected(4));
        System.out.println(dfs);
    }

    @Test
    public void testBFS() {
        Graph g = new AdjacencyListGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        BFS bfs = new BFS(g, 4);
        assertTrue(bfs.isConnected(5));
        assertFalse(bfs.isConnected(0));
        System.out.println(bfs);
    }
}
