package com.company.twoPointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.
 * Example 1:
 * Input:
 * N = 6, X = 16
 * Arr[] = {1, 4, 45, 6, 10, 8}
 *
 * Example 2:
 * Input:
 * N = 5, X = 10
 * Arr[] = {1, 2, 4, 3, 6}
 * Output: Yes
 * Explanation: Arr[2] + Arr[4] = 4 + 6 = 10
 * */
public class TwoSum {

    public static void main(String[] args){
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target1 = 16;
        System.out.println("Key pair found : "+findKeyPair(arr,target1));
        System.out.println("With O(n) : "+findPair(arr,target1));
    }

    // O(nlogn)
    public static boolean findKeyPair(int[] arr, int target){
        Arrays.sort(arr);
        int i =0, j = arr.length - 1;
        while( i < j){
            if(arr[i]+arr[j] == target){
                return true;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] > target){
                j--;
            }
        }
        return false;
    }
    public static boolean findPair(int[] arr, int target){
        HashSet<Integer> numbers = new HashSet<>();
        for(int num: arr){
            int temp = target - num;
            if(numbers.contains(temp)){
                return true;
            } else {
                numbers.add(num);
            }
        }
        return false;
    }
}
