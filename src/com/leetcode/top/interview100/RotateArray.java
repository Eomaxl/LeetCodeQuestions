package com.leetcode.top.interview100;
/*
* You may have been using Java for a while. Do you think a simple Java array question can be a challenge?
* Let’s use the following problem to test.Problem: Rotate an array of n elements to the right by k steps.
* For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
*
*
* */
public class RotateArray {
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5,6};
        int k1 = 2;
        int[] arr2 = {1,2,3,4,5,6,7,8};
        int k2 = 3;
        int[] result1 = rotateArr(arr1,k1);
        int[] result2 = rotateArr(arr2,k2);
        printArr(result1);
        printArr(result2);
    }

    public static void printArr(int[] arr){
        for(int num: arr){
            System.out.print(num+" || ");
        }
        System.out.println();
    }

    public static int[] rotateArr(int[] arr, int k){
        k = k % arr.length;
        if(arr == null || k <0)
            throw new IllegalArgumentException("Illegal argument");

        int a = arr.length - k;
        reverse(arr, 0 , a-1);
        reverse(arr,a,arr.length -1);
        reverse(arr,0,arr.length- 1);
        return arr;
    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
