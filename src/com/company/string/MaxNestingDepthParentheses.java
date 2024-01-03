package com.company.string;

public class MaxNestingDepthParentheses {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int count = 0, maxCount = 0;
        for (char c: chars){
            if (c == '('){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            if (c == ')') {
                count--;
            }
        }
        return maxCount;
    }
}
