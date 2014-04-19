package com.graph;

/**
 * Created by usman on 06/11/2013.
 */
public interface Graph {

    /**
     * V() = bob sedgewick
     *
     * @return number of vertices
     */
    int getNumberOfEdges();

    /**
     * E() equivalent of bob
     *
     * @return
     */
    int getNumberOfVertices();

    /**
     * @return
     */
    Iterable<Integer> getAdjacencyList(int vertex);

    void addEdge(int from, int to);

    boolean isVertexValid(int vertex);
}
