package com.leetcode.ace.interview75.arraystring;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 *
 * */
public class IncreasingTripletSequence {
    public static  void main(String[] args){
        int[] num1 = {5,4,3,2,1};
        int[] num2 = {2,1,5,0,4,6};
        int[] num3 = {1,2,3,4,5};
        System.out.println(increasingTripletSequence(num1));
        System.out.println(increasingTriplet(num2));
        System.out.println(increasingTripletSequence(num3));
    }
    public static boolean increasingTripletSequence(int[] nums){
        int counter = 0;
        boolean result = false;
        for(int i = 1; i< nums.length; i++) {
//            System.out.println(nums[i]+" || ");
            if (nums[i-1] < nums[i]){
                counter++;
            } else {
                counter = 0;
            }
            if(counter>=2){
//                System.out.println("Inside true condition. ");
                result = true;
            }
        }
//        System.out.println("| **************************************** |");
        return result;
    }

    public static boolean increasingTriplet(int[] nums){
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for(int num: nums){
            if(num < firstNum){
                firstNum = num;
            } else if (num < secondNum){
                secondNum = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
