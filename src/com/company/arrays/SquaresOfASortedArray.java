package com.company.arrays;
/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * */
public class SquaresOfASortedArray {
    public static void main(String[] args){
        int[] nums = {-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        printArr(result);
    }

    public static int[] sortedSquares(int[] nums){
        int start = 0;
        int end = nums.length -1;
        int[] ans = new int[nums.length];

        for(int k = nums.length-1; k>=0; k--){
            int comp1 = nums[start]*nums[start];
            int comp2 = nums[end]*nums[end];

            if(comp1 > comp2){
                ans[k] = comp1;
                start++;
            } else {
                ans[k] = comp2;
                end--;
            }
        }
        return ans;
    }

    public static void printArr(int[] arr){
        System.out.println("-----------------------------------------------------");
        for(int num: arr){
            System.out.print(num+" | ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }
}
