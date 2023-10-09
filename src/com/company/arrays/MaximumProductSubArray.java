package com.company.arrays;
/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product. The test cases are generated so that the answer will fit in a 32-bit integer.
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * */
public class MaximumProductSubArray {
    public static void main(String[] args){
        int[] num1 = {2,3,-2,4};
        int[] num2 = {-2,0,-1};
        System.out.println("The output of the first arr :"+maxProductSubarray(num1));
        System.out.println("The output of the second arr :"+maxProductSubarray(num2));
    }

    public static int maxProductSubarray(int[] num){
        int n = num.length;

        int pf1 = 1;
        int pf2 = 1;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(pf1 == 0) {
                pf1 = num[i];
            } else {
                pf1 = pf1 * num[i];
            }
            max1 = Math.max(max1,pf1);
        }

        for(int i = n -1; i >=0; i--){
            if(pf2 == 0){
                pf2 = num[i];
            } else {
                pf2 = pf2 * num[i];
            }
            max2 = Math.max(max2,pf2);
        }
        return Math.max(max1, max2);
    }
}
