package com.leetcode.ace.interview75.arraystring;
/**
 * Given an integer array flowerbed containing 0's and 1's where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the
 * flowerbed without violating the no-adjacent flower rule and false otherwise.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        int counter = 0;
        for(int i =0; i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                boolean emptyLeftPot = (i ==0 ) || (flowerbed[i-1] == 0);
                boolean emptyRightPot = (i == flowerbed.length -1) || (flowerbed[i+1] == 0);
                if(emptyLeftPot && emptyRightPot){
                    flowerbed[i] = 1;
                    counter++;
                }
            }
        }
        return counter >= n;
    }
    public static void main(String[] args){
        int[] flowerBed = {1,0,0,0,1};
        int n = 1;
        int m = 2;
        System.out.println("First user case : "+canPlaceFlowers(flowerBed,n));
        System.out.println("Second user case : "+canPlaceFlowers(flowerBed,m));
    }
}
