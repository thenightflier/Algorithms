package com.graph.search;

import com.graph.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by usman on 10/11/2013.
 */
public class BFS {

    private Graph graph;
    private boolean isVisited[];
    private int edgeTo[];

    public BFS(Graph graph, int startingNode) {
        this.graph = graph;
        isVisited = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        bfs(startingNode);

    }

    private void bfs(int startingNode) {
        Queue<Integer> nodesToTraverse = new LinkedList<Integer>();
        nodesToTraverse.add(startingNode);
        isVisited[startingNode]=true;
        while (!nodesToTraverse.isEmpty()) {
            int parentNode = nodesToTraverse.remove();
            for (int node : this.graph.getAdjacencyList(parentNode)) {
                if (!isVisited[node]) {
                    edgeTo[node]=parentNode;
                    isVisited[node] = true;
                    nodesToTraverse.add(node);
                }
            }
        }
    }

    public boolean isConnected(int vertex) {
        return isVisited[vertex];
    }

    @Override
    public String toString() {
        return "BFS{" +
                "graph=" + graph +
                ", isVisited=" + Arrays.toString(isVisited) +
                ", edgeTo=" + Arrays.toString(edgeTo) +
                '}';
    }
}
