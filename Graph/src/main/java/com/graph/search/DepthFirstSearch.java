package com.graph.search;

import com.graph.Graph;

import java.util.Arrays;

/**
 * Graph searching algo that searches by going in deep
 * Created by usman on 07/11/2013.
 */
public class DepthFirstSearch {
    private Graph graph;
    private boolean[] isVisited;
    private int edgeTo[];

    public DepthFirstSearch(Graph g, int startingNode) {
        this.graph = g;
        isVisited = new boolean[g.getNumberOfVertices()];
        edgeTo = new int[g.getNumberOfVertices()];
        dfs(startingNode);

    }

    private void dfs(int startingNode) {
        this.isVisited[startingNode] = true;
        for (int node : this.graph.getAdjacencyList(startingNode)) {
            if (!isVisited[node]) {
                edgeTo[node]=startingNode;
                dfs(node);
            }
        }

    }

    public boolean isConnected(int vertex){
        boolean vertexValid = graph.isVertexValid(vertex);
        if(vertexValid){
            return isVisited[vertex];
        }
        return vertexValid;
    }

    @Override
    public String toString() {
        return "DepthFirstSearch{" +
                "graph=" + graph +
                ", isVisited=" + Arrays.toString(isVisited) +
                ", edgeTo=" + Arrays.toString(edgeTo) +
                '}';
    }
}
