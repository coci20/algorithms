/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author prasannjitk
 */
public class OrderCharacters {
    public static void main(String[] args) {
        char[] A = {'$', '$', '@', '%','$','$','@','!','%'};
        char[] B = {'%', '$', '@', '*', '!'};
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        
        TreeMap<Integer, ArrayList<Character>> symbolMap =
                new TreeMap<>();
        for(Character a : A) {
            int rank = map.get(a);
            if(!symbolMap.containsKey(rank)){
                ArrayList<Character> list =
                        new ArrayList<>();
                list.add(a);
                symbolMap.put(rank, list);
            } else {
                symbolMap.get(rank).add(a);
            }            
        }
        
        int index = 0;
        char[] result = new char[A.length];
        for(Integer i : symbolMap.keySet()) {
            for(Character c : symbolMap.get(i)) {
                result[index] = c;
                index++;
            }
        }
        for(Character c: result) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
