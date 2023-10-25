package com.leetcode.ace.interview75.SlidingWindow;
/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 *
 *
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 * */
public class MaximumAverageSubArray {

    public static void main(String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        int[] nums1= {5};
        System.out.println("First series :"+maxAverage(nums,4));
        System.out.println("Second series :"+maxAverage(nums1,1));

    }

    public static double maxAverage(int[] nums, int k){
        double maxSum = 0;
        for(int i = 0; i<k; i++){
            maxSum += nums[i];
        }
        for(int i = k; i<nums.length - 1; i++){
            double sum = maxSum + nums[i] - nums[i-k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum/k;
    }


}
