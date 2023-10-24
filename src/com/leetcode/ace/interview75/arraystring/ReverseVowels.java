package com.leetcode.ace.interview75.arraystring;
/**
 *
 * */
public class ReverseVowels {
    boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    void swap(char[] ch, int start, int end){
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
    }

    public String reverseVowels(String s){
        int start = 0;
        int end = s.length() - 1;
        char[] sChar = s.toCharArray();
        while(start<end){
            while(start < s.length() && !isVowels(sChar[start])){
                start++;
            }
            while(end >= 0 && !isVowels(sChar[end])){
                end--;
            }
            if(start<end){
                swap(sChar,start++,end--);
            }
        }
        return new String(sChar);
    }

    public static void main(String[] args){
        ReverseVowels obj = new ReverseVowels();
        System.out.println("Reversing a vowel in a string :"+ obj.reverseVowels("leetcode"));
    }
}
