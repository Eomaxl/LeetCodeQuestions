package com.leetcode.top.interview150.array.string;

import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the
 * integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2
 * candies respectively.
 *
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies
 * respectively. The third child gets 1 candy because it satisfies the above two conditions.
 * */
public class Candy {
    public static void main(String[] args){
        int[] ratings = {1,2,2};
        System.out.println("Brute Force approach :"+numCandiesBruteForce(ratings));
    }
    public static int numCandiesBruteForce(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        boolean hasChanged = true;
        while(hasChanged){
            hasChanged = false;
            for(int i = 0; i < ratings.length; i++){
                if(i != ratings.length-1 && ratings[i]> ratings[i+1] && candies[i] >= candies[i+1]){
                    candies[i] = candies[i+1] + 1;
                    hasChanged = true;
                }
                if( i > 0 && ratings[i] > ratings[i-1] && candies[i-1] > candies[i]){
                    candies[i] = candies[i-1] + 1;
                    hasChanged = true;
                }
            }
        }
        int sum = 0;
        for(int candy : candies){
            sum += candy;
        }
        return sum;
    }
}
