package com.company.arrays;
/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 *
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * */
public class FindMissingPositive {
    public static void main(String[] args){
        int[] nums1 = {1,2,0};
        int[] nums2 = {3,4,-1,1};
        int[] nums3 = {7,8,9,11,12};
        System.out.println(" Output 1 : "+findMissingPositive(nums1));
        System.out.println(" Output 2 : "+findMissingPositive(nums2));
        System.out.println(" Output 3 : "+findMissingPositive(nums3));
    }

    public static int findMissingPositive(int[] nums){
        int n = nums.length;
        int i =0;
        while(i < n){
            if(nums[i] == i+1){
                i++;
                continue;
            }
            if(nums[i] <= 0 || nums[i] >n){
                i++;
                continue;
            }

            int idx1 = i;
            int idx2 = nums[i] - 1;

            if(nums[idx1] == nums[idx2]){
                i++;
                continue;
            }
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }
        for(int j =0 ; j< n; j++){
            if(nums[j] != j+1)
                return j+1;
        }
        return n+1;
    }
}
