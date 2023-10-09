package com.company.arrays;
/**
 *Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * */
public class MaximumSubArray {
    public static void main(String[] args){
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};
        System.out.println("output1 :"+maxSubArray(nums1));
        System.out.println("output2 :"+maxSubArray(nums2));
        System.out.println("output3 :"+maxSubArray(nums3));
    }

    public static int maxSubArray(int[] nums){
        int cmax = 0;
        int omax = Integer.MIN_VALUE;

        for(int i =0; i<nums.length; i++){
            if(cmax < 0) {
                cmax = nums[i];
            } else {
                cmax = cmax + nums[i];
            }
            omax = Math.max(omax,cmax);
        }
        return omax;
    }
}
