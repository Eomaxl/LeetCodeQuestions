package com.leetcode.ace.interview75.two.pointers;
/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * */
public class IsSubsequence {
    public static void main(String[] args){
        String str1s = "abc";
        String str1t = "ahbgdc";
        String str2s = "axc";
        String str2t = "ahbgdc";
        System.out.println("Is it a valid subSequence "+isValid(str1s,str1t));
        System.out.println("Is it a valid subSequence "+isValid(str2s,str2t));
    }
    public static boolean  isValid(String str1, String str2){
        if(str1.length() == 0) return true;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int counter = 0;
        for(int i = 0 ; i < ch2.length; i++) {
            if(counter <= ch1.length && ch2[i] == ch1[counter] ){
                counter++;
            }
        }
        return counter == ch1.length;
    }
}
