package com.company.graph;
import java.util.*;

public class Graph {
    private Map<Integer,List<Integer>> adjacentList;

    public Graph(){
        adjacentList = new HashMap<>();
    }

    public void addVertex(int vertex){
        adjacentList.put(vertex,new ArrayList<>());
    }

    public void addEdges(int source, int destination){
        adjacentList.get(source).add(destination);
        adjacentList.get(destination).add(source);
    }

    public List<Integer> getNeighbors(int vertex){
        return adjacentList.get(vertex);
    }

    public List<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public void printGraph(){
        for(Map.Entry<Integer,List<Integer>> entry: adjacentList.entrySet()){
            System.out.print(entry.getKey()+" : ");
            for(int num: entry.getValue()){
                System.out.print(num+" | ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdges(1,2);
        graph.addEdges(1,5);
        graph.addEdges(2,3);
        graph.addEdges(3,5);
        graph.addEdges(3,4);
        graph.addEdges(4,5);

        System.out.println("Graph:");
        graph.printGraph();
        System.out.println("||----------- BFS Graph -----------||");
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<5; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        List<Integer> ans = graph.bfs(5,adj);
        for(int i =0; i<ans.size(); i++){
            System.out.print(ans.get(i) + " | ");
        }
    }
}
