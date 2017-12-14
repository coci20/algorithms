package practice.problems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author pprasank
 */
public class MinIndexSum {
    
    public static void main(String[] args) {
        String[] list1 = {"k", "Burger King"};
        String[] list2 = {"k", "Burger King"};
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        HashMap<String, Integer> map3 = new HashMap<String, Integer>();
        
        int n1 = list1.length;
        int n2 = list2.length;
        
        int min = n1 + n2 - 1;
        
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < n1; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < n2; i++) {
            map2.put(list2[i], i);
        }        
        
        for (String s: map1.keySet()) {
            if (map2.containsKey(s)) {
                int sum = map1.get(s) + map2.get(s);
                if (sum <= min) {
                    min = sum;
                    map3.put(s, sum);
                    res.add(s);
                }
            }
        }
        for (String s: map3.keySet())
            System.out.println(s);
    }
}
