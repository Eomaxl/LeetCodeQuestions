package com.company.arrays;
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 *  Example 2:
 *  Input: height = [4,2,0,3,2,5]
 *  Output: 9
 * */
public class TrappingRainWater {
    public static void main(String[] args){
        int[] height2 = {4,2,0,3,2,5};
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Output 1: "+trap(height1));
        System.out.println("Output 2: "+trappingWater(height2));
    }
    public static int trap(int[] height){
        int n = height.length;

        int[] prefixmax = new int[n];
        int[] sufixmax = new int[n];

        prefixmax[0] = height[0];
        for(int i =1; i<n;i++){
            prefixmax[i] = Math.max(prefixmax[i-1],height[i]);
        }

        sufixmax[n-1]=height[n-1];
        for(int i=n-2; i>=0; i--){
            sufixmax[i] = Math.max(sufixmax[i+1],height[i+1]);
        }

        int ans =0;
        for(int i=1; i<n; i++){
            ans+= Math.min(prefixmax[i],sufixmax[i]) - height[i];
        }
        return ans;
    }

    public static int trappingWater(int[] arr){
        int i =0;
        int j = arr.length -1;

        int prefix = 0;
        int suffix = 0;

        int ans = 0;

        while(i < j) {
            prefix = Math.max(prefix,arr[i]);
            suffix = Math.max(suffix,arr[j]);

            if(prefix <= suffix){
                ans = ans + prefix - arr[i];
                i++;
            } else {
                ans = ans + suffix - arr[j];
                j--;
            }
        }
        return ans;
    }
}
