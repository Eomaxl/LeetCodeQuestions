package com.company.graph;
/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 *
 * Example 1:
 * isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * output: 2
 *
 * */
import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0,1);
        adj.get(0).add(1,0);
        adj.get(0).add(2,1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0,1);
        adj.get(1).add(1,1);
        adj.get(1).add(2,1);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0,1);
        adj.get(2).add(1,0);
        adj.get(2).add(2,1);
        System.out.println("The number of provinces are :"+numberOfProvinces(adj));
    }

    public static int numberOfProvinces(ArrayList<ArrayList<Integer>> isConnected){
        int numberOfComponents = 0;
        int n = isConnected.size();
        boolean[] visit = new boolean[n];

        for(int i =0; i<n; i++){
            if(!visit[i]){
                numberOfComponents++;
                dfs(i,isConnected,visit);
            }
        }
        return numberOfComponents;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> isConnected, boolean[] visit){
        visit[node] = true;

        for(int i = 0; i<isConnected.size(); i++){
            if((isConnected.get(node).get(i) == 1) && !visit[i]){
                dfs(i,isConnected,visit);
            }
        }
    }
}
