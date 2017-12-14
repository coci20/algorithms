/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pprasank
 */
public class LongestSubs {
    public int lengthOfLongestSubstring(String s){
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String str = String.valueOf(c);            
            char[] visited = new char[128];
            int j = i + 1;
            visited[c] = 1;
            int len = 1;
            while (j <(s.length()-1) && (visited[s.charAt(j)] != 1)){
                visited[s.charAt(j)] = 1;
                len++;
                str += String.valueOf(s.charAt(j));
                j++;
            }
            if (len > longest) longest=len;
            System.out.println(str);
            str = "";
        }
        return longest;
    }
    
    public int better_lengthofSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ii : map.keySet())
            System.out.println(ii);
        int[] nums = {1,2,3,4,5};
        Set<Integer> set = new HashSet<>();
        for(Integer i:nums) {
            if(set.contains(i)) {
                System.out.println("duplicate exists");
                break;
            }
            set.add(i);
        }

        //initialize
        //if (s.length() > 0) set.add(s.charAt(0));
        int i = 0;
        int j = 1;
        int size = 0;
        while (i < j && j <= s.length()) {
            String ss = s.substring(i, j);
            char c = ss.charAt(ss.length()-1);            
            if (!map.containsKey(c)) {
                map.put(c, j-1);
                if (ss.length() > size) size = ss.length();                
            }
            else {
                i = map.get(c) + 1;
                map.put(c, j-1);
            }
            j++;
        }
        return size;
    }
    public static void main(String[] args){
        LongestSubs sol = new LongestSubs();
        String s = "tmmzuxt";
       // System.out.println(sol.lengthOfLongestSubstring("abca&&&*()(((bcbb"));
        System.out.println(sol.better_lengthofSubstring(s));
    }
}
