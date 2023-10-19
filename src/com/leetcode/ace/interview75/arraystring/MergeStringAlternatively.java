package com.leetcode.ace.interview75.arraystring;
/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * */
public class MergeStringAlternatively {
    public static void main(String[] args){
        String str1 = "abc";
        String str2 = "pqr";
        System.out.println("The merged string of the two words given are :"+mergedString(str1,str2));
        String str3 = "ab";
        String str4 = "pqrs";
        System.out.println("The merged string of the two words given are :"+mergedString(str3,str4));
    }

    public static String mergedString(String str1, String str2){
        StringBuilder sb = new StringBuilder();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        if(ch1.length == ch2.length){
            for(int i =0; i<ch1.length; i++){
                sb = sb.append(ch1[i]).append(ch2[i]);
            }
        } else if(ch1.length < ch2.length) {
            int i =0;
            for(; i<ch1.length; i++){
                sb = sb.append(ch1[i]).append(ch2[i]);
            }
            for(;i<ch2.length;i++){
                sb = sb.append(ch2[i]);
            }
        } else {
            int i =0;
            for(; i<ch2.length; i++){
                sb = sb.append(ch1[i]).append(ch2[i]);
            }
            for(;i<ch1.length;i++){
                sb = sb.append(ch1[i]);
            }
        }
        return sb.toString();
    }
}
