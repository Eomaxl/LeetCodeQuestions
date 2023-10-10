package com.company.bitmanipulation;
/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * */
public class SingleNumberII {
    public static void main(String[] args){
        int[] nums1 = {};
        int[] nums2 = {};
        System.out.println("Output 1: "+singleNumber(nums1));
        System.out.println("Output 2: "+singleNumber(nums2));
    }

    public static boolean checkBit(int num, int j){
        if((num & (1 << j)) == 0){
            return false;
        } else {
            return true;
        }
    }

    public static int singleNumber(int[] nums){
        int ans = 0;
        for(int i =0; i<32; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(checkBit(nums[j], i) == true)
                    count++;
            }
            if(count % 3 == 1){
                ans = ans + ( 1 << i);
            }
        }
        return ans;
    }
}
