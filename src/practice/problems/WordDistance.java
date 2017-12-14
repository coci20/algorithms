/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author prasannjitk
 */
public class WordDistance {
    Map<String, Integer> map;
    public WordDistance(String[] words) {
        Set<String> set = new HashSet<>();
        for(String w : words)
            set.add(w);
        List<String> list = new ArrayList<>(set);
        map = new HashMap<>();
        String t = "";
        for(int i = 0; i < list.size(); i++) {
            String w1 = list.get(i);
            for(int j = i + 1; j < list.size(); j++) {
                String w2 = list.get(j);
                int distance = shortestDistance(words, w1, w2);
                if(w1.compareTo(w2) > 0)
                    t = w1 + ":" + w2;
                else
                    t = w2 + ":" + w1;
                map.put(t, distance);
            }
        }
    }
    public void printMap() {
        for(String t : map.keySet()) {
            String[] parts = t.split(":");
            System.out.println(parts[0] + "-" + parts[1] + ":" + map.get(t));
        }
    }
    public int shortestDistance(String[] words, String w1, String w2) {
        int dist = Integer.MAX_VALUE;
        int a = -1;
        String prev = "";
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            if(!(s.compareTo(w1) == 0 || s.compareTo(w2) == 0))
                continue;
            else {
                if(prev.compareTo("") == 0 || prev.compareTo(s) == 0) {
                    prev = s;
                    a = i;
                } else if((s.compareTo(w1) == 0 && prev.compareTo(w2) == 0) ||
                    (s.compareTo(w2) == 0 && prev.compareTo(w1) == 0)){
                    dist = Math.min(dist, i - a);
                    prev = s.compareTo(w1) == 0 ? w1 : w2;
                    a = i;
                }
            }
        }
        return dist;
    }
    
    public int shortest(String word1, String word2) {
        String t = "";
        if(word1.compareTo(word2) > 0)
            t = word1 + ":" + word2;
        else
            t = word2 + ":" + word1;
        int n = 100;
        System.out.println(Integer.reverse(n));
        return map.get(t);
        
    }
    
    public static void main(String[] args) {
        String[] words = {"practice","makes","perfect","coding","makes"};
        WordDistance WD = new WordDistance(words);
        WD.printMap();
        System.out.println(WD.shortest(words[0], words[2]));
        String s = "prasannjit";
        System.out.println(s.substring(0,10));
        Queue<Integer> q = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        set.add(l1);
        l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        set.add(l1);
        System.out.println(set.size());
    }
}
