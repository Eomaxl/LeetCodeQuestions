package com.company.graph.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are n people in a social group labeled from 0 to n - 1. You are given an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.
 * Friendship is symmetric. That means if a is friends with b, then b is friends with a. Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.
 * Return the earliest time for which every person became acquainted with every other person. If there is no such earliest time, return -1.
 * */
public class EarliestMomentWhenEveryoneBecameFriends {
    public int earliestAcq(int[][] logs, int n) {

        // First, we need to sort the events in chronological order.
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer tsp1 = new Integer(log1[0]);
                Integer tsp2 = new Integer(log2[0]);
                return tsp1.compareTo(tsp2);
            }
        });

        // Initially, we treat each individual as a separate group.
        int groupCount = n;
        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int timestamp = log[0], friendA = log[1], friendB = log[2];

            // We merge the groups along the way.
            if (uf.union(friendA, friendB)) {
                groupCount -= 1;
            }

            // The moment when all individuals are connected to each other.
            if (groupCount == 1) {
                return timestamp;
            }
        }

        // There are still more than one groups left,
        //  i.e. not everyone is connected.
        return -1;
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;

    public UnionFind(int size) {
        this.group = new int[size];
        this.rank = new int[size];
        for (int person = 0; person < size; ++person) {
            this.group[person] = person;
            this.rank[person] = 0;
        }
    }

    /**
     * Return the id of group that the person belongs to.
     */
    public int find(int person) {
        if (this.group[person] != person)
            this.group[person] = this.find(this.group[person]);
        return this.group[person];
    }

    /**
     * If it is necessary to merge the two groups that x, y belong to.
     * @return true: if the groups are merged.
     */
    public boolean union(int a, int b) {
        int groupA = this.find(a);
        int groupB = this.find(b);
        boolean isMerged = false;

        // The two people share the same group.
        if (groupA == groupB)
            return isMerged;

        // Otherwise, merge the two groups.
        isMerged = true;
        // Merge the lower-rank group into the higher-rank group.
        if (this.rank[groupA] > this.rank[groupB]) {
            this.group[groupB] = groupA;
        } else if (this.rank[groupA] < this.rank[groupB]) {
            this.group[groupA] = groupB;
        } else {
            this.group[groupA] = groupB;
            this.rank[groupB] += 1;
        }

        return isMerged;
    }
}

