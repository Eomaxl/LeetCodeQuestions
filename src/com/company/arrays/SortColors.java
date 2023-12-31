package com.company.arrays;

public class SortColors {
    public static void main(String[] args){
        int[] arr = new int[] {2,0,2,1,1,0};
        sortColors(arr);
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sortColors(int[] arr){
        int p0 =0, curr =0;
        int p2 = arr.length - 1;
        int temp;

        while(curr <= p2){
            if (arr[curr] == 0){
                temp  = arr[p0];
                arr[p0++] = arr[curr];
                arr[curr++] = temp;
            } else if (arr[curr] == 2){
                temp = arr[curr];
                arr[curr] = arr[p2];
                arr[p2--] = temp;
            } else {
                curr++;
            }
        }
    }
}
