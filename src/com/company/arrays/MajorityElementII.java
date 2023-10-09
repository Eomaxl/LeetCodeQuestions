package com.company.arrays;

import java.util.*;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 * */
public class MajorityElementII {

    public static void main(String[] args){
        int[] nums1 = {3,2,3};
        int[] nums2 = {1};
        int[] nums3 = {1,2};
        System.out.println("Output 1 :"+majorityElement(nums1));
        System.out.println("Output 2 :"+majorityElement(nums2));
        System.out.println("Output 3 :"+majorityElement(nums3));
    }

    public static List<Integer> majorityElement(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        int maxNumber = nums.length/3;

        Map<Integer,Integer> listOfNumbers = new HashMap<Integer,Integer>();
        for(int i=0; i< nums.length; i++){
            if(!listOfNumbers.containsKey(nums[i])) {
                listOfNumbers.put(nums[i],1);
            } else {
                int val = listOfNumbers.get(nums[i]);
                listOfNumbers.put(nums[i],val+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: listOfNumbers.entrySet()){
            if(entry.getValue() > maxNumber)
                result.add(entry.getKey());
        }
        return result;
    }
}
