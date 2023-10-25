package com.leetcode.ace.interview75.SlidingWindow;

import java.util.*;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 *
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 *
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * */
public class MaximumNumberOfVowelsInSubstring {
    public static void main(String[] args){
        String str1 = "abciiidef";
        String str2 = "aeiou";
        String str3 = "leetcode";
        System.out.println("Answer 1 : "+maxNumOfVowels(str1,3));
        System.out.println("Answer 2 : "+maxNumOfVowels(str2,2));
        System.out.println("Answer 3 : "+maxNumOfVowels(str3,3));
    }

    public static int maxNumOfVowels(String str, int k){
        int count = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = 0; i<k; i++){
            count += vowels.contains(str.charAt(i)) ? 1 : 0;
        }
        int answer = count;
        for(int i = k; i < str.length(); i++){
            count += vowels.contains(str.charAt(i)) ? 1: 0;
            count -= vowels.contains(str.charAt(i-k)) ? 1: 0;
            answer = Math.max(answer, count);
        }
        return answer;
    }

}
