package com.leetcode.ace.interview75.arraystring;

import java.util.ArrayList;
import java.util.List;
/**
 * Input: candies = [2,3,5,1,3], extra candies =3
 * Output: [true,true,true,false,true]
 * */
public class KidsWithGreatestNumberCandies {
    public static void main(String[] args){
        int[] inputs = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> answer  = kidsWithCandies(inputs,extraCandies);
        for(boolean val: answer){
            System.out.print(val +" || ");
        }
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> results = new ArrayList<>();
        int maxCandiesNumber = -1;
        for(int num: candies){
            if(num > maxCandiesNumber)
                maxCandiesNumber = num;
        }
        for(int num: candies){
            if((num + extraCandies) >= maxCandiesNumber){
                results.add(true);
            } else {
                results.add(false);
            }
        }
        return results;
    }
}
