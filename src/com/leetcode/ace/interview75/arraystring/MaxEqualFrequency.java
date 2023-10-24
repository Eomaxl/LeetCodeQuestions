package com.leetcode.ace.interview75.arraystring;

import java.util.*;

public class MaxEqualFrequency {
    public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        int maxEqual = 0; // Initialize maxEqual to 0
        int updateCount = 0; // Initialize updateCount to 0

        // Iterate through the signals until the end of the shorter signal
        int n = signalOne.size();
        int m = signalTwo.size();
        int minLen = Math.min(n, m);

        for (int i = 0; i < minLen; i++) {
            if (signalOne.get(i) == signalTwo.get(i)) {
                if (signalOne.get(i) > maxEqual) {
                    maxEqual = signalOne.get(i);
                    updateCount++;
                }
            } else {
                break; // Signals are no longer equal, break the loop
            }
        }

        return updateCount;
    }

    public static void main(String[] args) {
        List<Integer> signalOne = new ArrayList<>();
        signalOne.add(1);
        signalOne.add(2);
        signalOne.add(3);
        signalOne.add(3);
        signalOne.add(3);
        signalOne.add(5);
        signalOne.add( 4);
        List<Integer> signalTwo = new ArrayList<>();
        signalTwo.add(1);
        signalTwo.add(2);
        signalTwo.add(3);
        signalTwo.add(4);
        signalTwo.add(3);
        signalTwo.add(5);
        signalTwo.add(4);

        int maxEqualUpdates = updateTimes(signalOne, signalTwo);
        System.out.println("MaxEqual was updated " + maxEqualUpdates + " times.");
    }
}

