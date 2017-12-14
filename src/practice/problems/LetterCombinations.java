/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prasannjitk
 */
public class LetterCombinations {
    public static Map<Character, List<Character>> createMap() {
        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> list;
        char c, i;
        
        for(c = 'a', i = '2'; c <= 'o' && i <= '9'; c++, i++) {
            list = new ArrayList<>();
            list.add(c++);
            list.add(c++);
            list.add(c);
            map.put(i, list);            
        }
        list = new ArrayList<>();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        map.put('7', list);
        list = new ArrayList<>();
        list.add('t');
        list.add('u');
        list.add('v');
        map.put('8',list);
        list = new ArrayList<>();        
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        map.put('9',list);
        return map;
    }
    
    public static void printMap(Map<Character, List<Character>> map) {
        for(Character key : map.keySet()) {
            System.out.print(key + ": ");
            for(Character c : map.get(key)){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    
    public static List<String> generateList(String digits,
            Map<Character, List<Character>> map, int index,
            int len) {
        List<String> list = new ArrayList<>();
        if(index == len) {            
            char c = digits.charAt(index);
            for(Character ch : map.get(c)){
                list.add(String.valueOf(ch));
            }
            return list;
        } else {
            List<String> collect = generateList(digits, map, index + 1, len);
            char c = digits.charAt(index);
            for(Character ch : map.get(c)) {
                for(String s : collect) {
                    list.add(String.valueOf(ch) + s);
                }
            }
            return list;
        }
    }
    
    public static void letterCombinations(String digits) {
        
        Map<Character, List<Character>> map = createMap();
        int i;
        for(i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if(!map.containsKey(c)) {
                System.out.println(c + " is not present in map");
                return;
            }
        }
        //printMap(map);
        if(digits.length() <= 0)
            return;
        
        List<String> list = generateList(digits, map, 0, digits.length() - 1);
        for(String s : list) {
            System.out.println(s);
        }
    }
    
    public static void main(String[] args) {
        letterCombinations("23565");
        
    }
}
