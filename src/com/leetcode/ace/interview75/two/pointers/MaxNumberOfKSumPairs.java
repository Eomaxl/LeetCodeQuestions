package com.leetcode.ace.interview75.two.pointers;

import java.util.*;

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 *
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * */
public class MaxNumberOfKSumPairs {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] nums1 = {3,1,3,4,3};
        System.out.println(maxNumberOfPairs(nums,5));
        System.out.println(maxNumberOfPairs(nums1,6));
    }
    public static int maxNumberOfPairs(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        for(int i =0; i<nums.length; i++){
            int comp = k - nums[i];
            if(map.getOrDefault(comp,0) > 0){
                map.put(comp, map.get(comp) - 1);
                counter++;
            } else {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return counter;


    }
}
