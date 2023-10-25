package com.leetcode.ace.interview75.two.pointers;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * */
public class ContainerWithMostWater {

    public static void main(String[] args){
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int[] heights1 = {1,1};
        System.out.println("Max Area : "+maxArea(heights));
        System.out.println("Max Area : "+maxArea(heights1));
    }

    public static int maxArea(int[] heights){
        int start = 0, end = heights.length - 1, area = 0;
        while (start < end){
            area = Math.max(area, Math.min(heights[start],heights[end]) * (end - start));
            if(heights[start] < heights[end]){
                start += 1;
            } else {
                end -= 1;
            }
        }
        return area;
    }
}
