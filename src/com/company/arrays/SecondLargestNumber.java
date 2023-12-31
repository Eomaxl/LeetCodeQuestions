package com.company.arrays;

public class SecondLargestNumber {
    public static void main(String[] args){

    }

    public static int getSecondLargest(int[] arr, int len){
        int largest = arr[0];
        int secondLargest = -1;
        for(int i =0 ; i< len; i++){
            if (arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static int getSecondSmallest(int[] arr, int len){
        int smallest  = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for(int i =1; i< len; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] < secondSmallest && arr[i] > smallest){
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }
}
