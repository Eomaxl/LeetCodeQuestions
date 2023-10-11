package com.company.HashMap;
import java.util.*;
/**
 * Given an array of N integers. Write a program to check whether an arithmetic progression can be formed using all the given elements.
 *
 *  Example 1:
 *  Input:
 *  N=4
 *  arr[] = { 0,12,4,8 }
 *  Output: YES
 *  Explanation: Rearrange given array as
 *  {0, 4, 8, 12}  which forms an
 *  arithmetic progression.
 *
 *  Example 2:
 *  Input:
 *  N=4
 *  arr[] = {12, 40, 11, 20}
 *  Output: NO
 * */
public class CheckAP {
    public static void main(String[] args){
        int arr1[] = {0,12,4,8};
        int n1 = 4;
        int arr2[] = {12, 40, 11, 20};
        int n2 = 4;
        System.out.println("First Output 1: "+checkAP(arr1,n1));
        System.out.println("First Output 1: "+checkAP(arr2,n2));
    }
    public static boolean checkAP(int[] arr, int num){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int smallest = Integer.MAX_VALUE, second_smallest = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {

            // Find the smallest and update second smallest
            if (arr[i] < smallest) {
                second_smallest = smallest;
                smallest = arr[i];
            }

            // Find second smallest
            else if (arr[i] != smallest
                    && arr[i] < second_smallest)
                second_smallest = arr[i];

            // Check if the duplicate element found or not
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            }

            // If duplicate found then return false
            else
                return false;
        }

        // Find the difference between smallest and second smallest
        int diff = second_smallest - smallest;

        // As we have used smallest and second smallest,so we should now only check for n-2 elements
        for (int i = 0; i < num - 1; i++) {
            if (!hm.containsKey(second_smallest))
                return false;
            second_smallest += diff;
        }
        return true;

    }
}
