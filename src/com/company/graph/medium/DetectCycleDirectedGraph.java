package com.company.graph.medium;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {
    private  int V;
    private  List<List<Integer>> adj;

    public DetectCycleDirectedGraph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
        if(recStack[i])
            return true;

        if(visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);
        for(Integer c: children){
            if(isCyclicUtil(c,visited,recStack))
                return true;
        }
        recStack[i] = false;
        return false;
    }

    public void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[V];
        boolean[] recStack  = new boolean[V];
        for(int i = 0; i<V; i++){
            if(isCyclicUtil(i,visited,recStack))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        DetectCycleDirectedGraph graph = new DetectCycleDirectedGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        if(graph.isCyclic()){
            System.out.println("Graph is cyclic");
        } else {
            System.out.println("Not cyclic");
        }
    }

}
