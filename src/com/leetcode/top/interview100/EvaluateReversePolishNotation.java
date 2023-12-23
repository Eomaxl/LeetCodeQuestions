package com.leetcode.top.interview100;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 *     expression.
 * Some examples:
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * */
public class EvaluateReversePolishNotation {

    public static void main(String[] args){
        String[] tokens = new String[] {"2","1","+","3","+"};
        String[] tokens2 = new String[] {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] token){
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for(String t : token){
            if(!operators.contains(t)){
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(t) {
                    case "+":
                        stack.push(String.valueOf(a+b));
                }
            }
        }

        return  returnValue;
    }
}
