package com.company.twoPointer;

import java.util.Arrays;

/**
 * Given an array Arr[] of size L and a number N, you need to write a program to
 * find if there exists a pair of elements in the array whose difference is N.
 *
 * Example 1:
 * Input:
 * L = 6, N = 78
 * arr[] = {5, 20, 3, 2, 5, 80}
 * Output: 1
 * Explanation: (2, 80) have difference of 78.
 *
 *
 * Example 2:
 * Input:
 * L = 5, N = 45
 * arr[] = {90, 70, 20, 80, 50}
 * Output: -1
 * Explanation: There is no pair with difference of 45.
 *
 *
 *
 * */
public class PairDifferenceGiven {
    public static void main(String[] args){
        int[] arr1 = {5, 20, 3, 2, 5, 80};
        int[] arr2 = {90, 70, 20, 80, 50};
        int target1 = 78;
        int target2 = 45;
        System.out.println("Output 1 :"+isPairDifferencePresent(arr1,target1));
        System.out.println("Output 2 :"+isPairDifferencePresent(arr2, target2));
    }

    public static boolean isPairDifferencePresent(int[] arr, int target){
        Arrays.sort(arr);
        int i =0, j = arr.length - 1;
        while( i < j){
            if(arr[j] -arr[i]  == target){
                return true;
            } else if(arr[j] - arr[i] < target){
                j--;
            } else  if(arr[j] - arr[i] > target) {
                i++;
            }
        }
        return false;
    }
}
