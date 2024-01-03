package com.company.string;
import java.util.*;
public class SortCharByFrequency {
    public String frequencySort(String s) {
        if( s == null || s.isEmpty()) return s;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        List<String> charString = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for(int i =1; i< chars.length; i++){
            if(chars[i] != chars[i-1]){
                charString.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(chars[i]);
        }
        charString.add(sb.toString());
        Collections.sort(charString, (a,b) -> b.length() - a.length());
        StringBuilder obj = new StringBuilder();
        for(String str: charString)
            obj.append(str);

        return obj.toString();
    }
}
