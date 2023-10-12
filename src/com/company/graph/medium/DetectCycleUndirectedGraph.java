package com.company.graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//using DFS
public class DetectCycleUndirectedGraph {
    private int V;
    private Map<Integer, List<Integer>> adj;

    public DetectCycleUndirectedGraph(int V){
        this.V = V;
        adj = new HashMap<>();
        for(int i =0; i<V; i++){
            adj.put(i,new ArrayList<>());
        }
    }

    public void addEdge(int source, int dest){
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

    private boolean isCyclicUtil(int V, int parent, boolean[] visited){
        visited[V]  = true;
        for(int i : adj.get(V)){
            if(!visited[i]){
                if(isCyclicUtil(i,V,visited)){
                    return true;
                } else if(i != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[V];
        for(int i =0; i<V; i++){
            if(!visited[i] && isCyclicUtil(i,-1,visited))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        DetectCycleUndirectedGraph graph = new DetectCycleUndirectedGraph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(1,3);
        graph.addEdge(3,4);

        if(graph.isCyclic()){
            System.out.println("Graph is cyclic ");
        } else {
            System.out.println("The graph is not cyclic");
        }
    }
}
