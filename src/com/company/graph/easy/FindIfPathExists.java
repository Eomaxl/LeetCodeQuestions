package com.company.graph.easy;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExists {
    private List<List<Integer>> adj;
    private int V;

    public FindIfPathExists(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEgde(int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public boolean validPath(int[][] edges,int source, int destination){
        for(int i =0; i<V; i++){
            addEgde(edges[i][0],edges[i][1]);
        }
        boolean[] visited = new boolean[V];
        return dfs(edges,source,destination,visited);
    }

    public boolean dfs(int[][]edges, int source, int destination, boolean[] visited){
        if(source == destination)
            return true;
        if(!visited[source]){
            visited[source] = true;
            for(int num: adj.get(source)){
                if(dfs(edges,num,destination,visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        FindIfPathExists pathExists = new FindIfPathExists(3);
        int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println(pathExists.validPath(edges,0,2));
    }

}
