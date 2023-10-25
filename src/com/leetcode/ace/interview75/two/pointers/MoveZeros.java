package com.leetcode.ace.interview75.two.pointers;
/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * */
public class MoveZeros {
    public static void main(String[] args){
        int num1[] = {0,1,0,3,12};
        int num2[] = {0};
        moveZeroes(num1);
        for(int num: num1){
            System.out.print(num + " || ");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] arr) {
        int j = 0;
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
