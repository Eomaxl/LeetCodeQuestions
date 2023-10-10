package com.company.twoPointer;
/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        System.out.println("height 1 :"+maxArea(height));
        System.out.println("height 2 :"+maxArea(height2));
    }
    public static int maxArea(int[] height) {
        int start = 0, end = height.length -1, area = 0;
        //find the starting index
        while (start < end) {
            area = Math.max(area, Math.min(height[start], height[end]) * (end - start));

            if (height[start] < height[end])
                start += 1;

            else
                end -= 1;
        }
        return area;
    }
}
