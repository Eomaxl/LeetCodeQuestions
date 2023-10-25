package com.leetcode.ace.interview75.arraystring;
/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * */
public class ProductArrayExceptSelf {
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {-1,1,0,-3,3};
        int[] answer1 = productExceptSelf(arr1);
        int[] answer2 = productExceptSelf(arr2);
        for(int num: answer1){
            System.out.print(num + " || ");
        }
        System.out.println();
        System.out.println("| ******************************************************** |");
        for(int num: answer2){
            System.out.print(num+" || ");
        }
    }

     public static int[] productExceptSelf(int[] nums){
        int[] rightArr = new int[nums.length];
        int[] answerArr = new int[nums.length];
        int[] leftArr = new int[nums.length];
        leftArr[0] = 1;
        for(int i =1; i <nums.length; i++){
            leftArr[i] = leftArr[i-1] * nums[i-1];
        }
        rightArr[nums.length-1] = 1;
        for(int i = nums.length - 2; i >= 0 ; i--){
            rightArr[i] = rightArr[i+1] * nums[i+1];
        }
        for(int i =0; i<nums.length;i++){
            answerArr[i] = leftArr[i] * rightArr[i];
        }
        return answerArr;
    }
}
