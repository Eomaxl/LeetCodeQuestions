package com.company.BinaryTree.Medium;

import java.util.*;

/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 *
 * */
public class ValidTree {
    public static void main(String[] args){
        int node = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println("Is the graph a valid tree :"+validTree(node,edges));
    }

    public static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Map<Integer,Integer> parent = new HashMap<>();
        parent.put(0,-1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: adj.get(node)){
                if(parent.get(node) == neighbor){
                    continue;
                }
                if(parent.containsKey(neighbor)){
                    return false;
                }
                queue.offer(neighbor);
                parent.put(neighbor,node);
            }
        }
        return  parent.size() == n;
    }
}
