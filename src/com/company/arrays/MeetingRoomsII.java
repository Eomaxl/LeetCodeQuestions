package com.company.arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals where intervals[i] = [start,end], return the minimum number of conference rooms required
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * */
public class MeetingRoomsII {
    public static void main(String[] args){
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println("Output 1 : "+minMeetingRooms(intervals1));
        System.out.println("Output 2 : "+minMeetingRooms(intervals2));
    }
    public static int minMeetingRooms(int[][] intervals){
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i =0; i<n; i++){
            start[i]= intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i =0;
        int j =0;
        int croom = 0;
        int oroom = Integer.MIN_VALUE;

        while(i<n){
            if(start[i] <end[j]){
                croom++;
                i++;
            } else {
                croom--;
                j++;
            }
            oroom = Math.max(oroom,croom);
        }
        return oroom;
    }
}
