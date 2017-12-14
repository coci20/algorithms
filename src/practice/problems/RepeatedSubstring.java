/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author prasannjitk
 */
public class RepeatedSubstring {
    
    public static int compareParts(String s1, String s2) {
        int count = 0;
        while(count < s2.length() &&
                s1.charAt(count) == s2.charAt(count))
            count++;
        return count;
    }
    public static void main(String[] args) {
        String s = "12345679012345678";
        String[] parts = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            parts[i] = s.substring(i);
        }
        for(String str : parts) {
            System.out.println(str);
        }
        Comparator<String> cmprtr = (String s1, String s2) -> {
            int i = 0;
            while(i < s1.length() && i < s2.length()) {
                if(s1.charAt(i) == s2.charAt(i))
                    i++;
                else
                    return s1.charAt(i) - s2.charAt(i); 
            }
            return s1.charAt(0) - s2.charAt(0);
        };
        Arrays.sort(parts, cmprtr);
        for(String str : parts) {
            System.out.println(str);
        }
        int i = 0;
        int max = 0;
        int diff = 0;
        String ans = "";
        while(i < parts.length - 1) {
            int j = i + 1;
            int len = compareParts(parts[i], parts[j]);
            max = Math.max(max, len);
            if(len == max) {
                diff = Math.abs(parts[i].length() - parts[j].length());
                ans = parts[i].length() > parts[j].length() ?
                        parts[i] : parts[j];
            }
            i++;
        }
        System.out.println(max + " " + diff + " " + ans);
        int index = s.indexOf(ans);
        System.out.println(s.substring(0,index) + "("
                + s.substring(index, diff + index) + ")");
        s = "123.232";
        if(s.contains("."))
            System.out.println(s.split("\\.")[0]);
        System.out.println(1/11119);
    }
}
