package com.company.arrays;
/**
 * Given an array nums of size n, return the majority element.The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * */
public class MajorityElement {
    public static void main(String[] args){
        int num1[] = {3,2,3};
        int num2[] = {2,2,1,1,1,2,2};
        System.out.println("Output 1 : "+majorityElement(num1));
        System.out.println("Output 2 : "+majorityElement(num2));
    }

    public static int majorityElement(int[] nums){
        int val = nums[0];
        int count = 1;

        for(int i = 1; i<nums.length; i++){
            if(count == 0){
                val = nums[i];
                count = 1;
            } else if (nums[i] == val) {
                count++;
            } else {
                count--;
            }
        }
        return val;
    }
}
