package com.leetcode.top.interview150.array.string;

public class HIndex {
    public static int hIndex(int[] citations){
        int n = citations.length;
        int[] papers =new int[n+1];
        for(int c:citations)
            papers[Math.min(n,c)]++;
        int k = n;
        for(int s = papers[n]; k>s; s+=papers[k])
            k--;
        return k;
    }

    public static void main(String[] args){
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
}
