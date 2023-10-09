package com.company.arrays;
/**
 * Given an integer array nums and two integers left and right,
 * return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 * Input: nums = [2,1,4,3], left = 2, right = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3]
 *
 * Example 2:
 * Input: nums = [2,9,2,5,6], left = 2, right = 8
 * Output: 7
 *
 * */
public class NumSubarrayBoundedMax {
    public static void main(String[] args){
        int[] nums1 = {2,1,4,3};
        int left1 = 2;
        int right1 = 3;
        int[] nums2 = {2,9,2,5,6};
        int left2 = 2;
        int right2 = 8;
        System.out.println("Output 1: "+numSubarrayBoundedMax(nums1,left1,right1));
        System.out.println("Output 2: "+numSubarrayBoundedMax(nums2,left2,right2));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right){
        int n = nums.length;
        int ans = 0;
        int j = 0;
        int prevcount = 0;

        for(int i =0; i<n;i++){
            if(nums[i] >= left && nums[i] <= right){
                ans += (i - j + 1);
                prevcount = (i - j + 1);
            } else if (nums[i] < left){
                ans += prevcount;
            } else {
                j = i + 1;
                prevcount = 0;
            }
        }
        return ans;
    }
}
