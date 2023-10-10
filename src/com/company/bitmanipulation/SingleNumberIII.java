package com.company.bitmanipulation;
/**
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 *
 *
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 *
 *
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 * */


public class SingleNumberIII {

    public static int[] singleNumber(int[] num){
        int v = 0;
        for(int i = 0; i<num.length; i++){
            v = v^num[i];
        }
        int idx = 0;
        for(int i =0; i < 32; i++){
            if(checkBit(v,i) == true){
                idx = i;
                break;
            }
        }
        int set1 = 0;
        int set2 = 0;
        for(int i = 0; i<num.length; i++){
            if(checkBit(num[i],idx) == true){
                set1 = set1 ^ num[i];
            } else {
                set2 = set2 ^ num[i];
            }
        }
        return new int[]{set1, set2};
    }

    public static boolean checkBit(int num, int j){
        if((num & (1<<j) )== 0){
            return false;
        } else {
            return true;
        }
    }
}
