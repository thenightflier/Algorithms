package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by usman on 06/11/2013.
 */
public class AdjacencyListGraph implements Graph {

    private int numberOfVertices;

    private List<Integer> adjacencyList[];
    private int numberOfEdges;

    public AdjacencyListGraph(int vertices) {
        if (vertices <= 0)
            throw new IllegalArgumentException("vertices should be greater than zero");

        adjacencyList = (ArrayList<Integer>[]) new ArrayList[vertices];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        this.numberOfVertices = vertices;

    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public Iterable<Integer> getAdjacencyList(int vertex) {
        return this.adjacencyList[vertex];
    }

    @Override
    public void addEdge(int from, int to) {
        if (!validate(from, to)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        this.adjacencyList[from].add(to);
        this.adjacencyList[to].add(from);
        numberOfEdges++;
    }

    @Override
    public boolean isVertexValid(int vertex) {
        return validate(vertex);
    }

    private boolean validate(int... indices) {
        for (int index : indices) {
            if (index < 0 || index >= getNumberOfVertices()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdjacencyListGraph{" +
                "numberOfVertices=" + numberOfVertices +
                ", adjacencyList=" + Arrays.toString(adjacencyList) +
                ", numberOfEdges=" + numberOfEdges +
                '}';
    }
}
