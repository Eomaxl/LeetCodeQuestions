package com.company.arrays;
/*
* Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n.
* If no such positive integer exists, return -1. Note that the returned integer should fit in 32-bit integer,
* if there is a valid answer but it does not fit in 32-bit integer, return -1.
*  Example 1:
* Input: n = 12
* Output: 21
*
*
* Example 2:
* Input: n = 21
Output: -1
* */
import java.util.Arrays;

public class NextGreaterElementIII {
    public static void main(String[] args){
        int num1 = 12;
        int num2 = 21;
        System.out.println(nextGreaterElement(num1));
        System.out.println(nextGreaterElement(num2));
    }

    public static int nextGreaterElement(int n) {
        char[] number = (n+"").toCharArray();
        int i;
        for(i =number.length-1; i> 0; i--){
            if(number[i-1] < number[i])
                break;
        }
        if(i ==0){
            return -1;
        }
        int x = number[i-1];
        int smallest = i;

        for(int j = i+1; j<number.length; j++){
            if(number[j] > x && number[j] <= number[smallest]){
                smallest = j;
            }
        }

        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;

        Arrays.sort(number,i,number.length);

        long ans = Long.parseLong(new String(number));

        if(ans > Integer.MAX_VALUE){
            return -1;
        } else {
            return (int)ans;
        }
    }
}
