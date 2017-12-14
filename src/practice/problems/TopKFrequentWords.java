/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prasannjitk
 */
public class TopKFrequentWords {
    static public class Pair {
        String word;
        int count;
        Pair(String w, int c) {
            word = w;
            count = c;
        }
    }
    public static void getTopK(String[] input,
            int k) {
        Map<String, Integer> map = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        for(String w : input) {
            if(!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                int c = map.get(w);
                map.put(w, c + 1);
            }
        }
        for(String key : map.keySet()) {
            Pair p = new Pair(key, map.get(key));
            list.add(p);
        }
        Comparator<Pair> comptr = 
                (Pair p1, Pair p2) -> {
                    if(p1.count == p2.count)
                        return p1.word.compareTo(p2.word);
                    else
                        return p2.count - p1.count;
                };
        Collections.sort(list, comptr);
        for(int i = 0; i < k; i++) {
            System.out.println(list.get(i).word);
        }
    }
    public static void main(String[] args) {
        String[] input = 
        {
            "the", "day", "is", "sunny", "the",
            "the", "the", "sunny", "is", "is"
        };
        int k = 3;
        getTopK(input, k);
    }
}
