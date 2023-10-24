package com.leetcode.ace.interview75.arraystring;
/**
 * Example 1:
 * Input : s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * */
public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        StringBuilder sb  = trimSpaces(s);
        reverse(sb,0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public static StringBuilder trimSpaces(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' ') ++left;
        while(left <= right && s.charAt(right) == ' ') --right;
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char c = s.charAt(left);
            if(c != ' ') sb.append(c);
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            ++left;
        }
        return sb;
    }

    public static void reverse(StringBuilder sb, int left, int right){
        while(left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    public static void reverseEachWord(StringBuilder sb){
        int s = sb.length();
        int start = 0, end = 0;
        while(start < s) {
            while(end < s && sb.charAt(end) != ' ') ++end;
            reverse(sb,start, end - 1);
            start = end + 1;
            ++end;
        }
    }
}
