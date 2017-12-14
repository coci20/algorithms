/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prasannjitk
 */
public class MinimumHeightTrees {
    
    public static void printMap(Map<Integer, List<Integer>> map){
        for(Integer v : map.keySet()){
            System.out.print(v + ": ");
            for(Integer child : map.get(v)){
                System.out.print(child + " ");
            }
            System.out.println();
        }
    }
    
    public static void DFS(int[] visited, Map<Integer, List<Integer>> map,
            List<Integer> list, int[] height, int level) {
        int i;
        for(i = 0; i < list.size(); i++) {
            int v = list.get(i);
            if(visited[v] != 1) {
                visited[v] = 1;
                if(height[0] < level + 1)
                    height[0]++;
                if(map.get(v).size() > 0){
                    DFS(visited, map, map.get(v), height, level + 1);
                }
            }
        }
    }
    
    public static void findMinHeightHelper(Map<Integer, List<Integer>> map,
            int n) {
        int i;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> hMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(i = 0; i < n; i++) {
            int[] visited = new int[n];
            visited[i] = 1;
            if(map.get(i) != null && map.get(i).size() > 0) {
                int[] height = new int[1];
                height[0] = 0;
                DFS(visited, map, map.get(i), height, 0);                
                hMap.put(i, height[0]);
                min = Math.min(min, height[0]);
            }                        
        }
        
        System.out.println();
        
        for(Integer v: hMap.keySet()) {
            System.out.println(v + ": " + hMap.get(v));
        }
        
        for(Integer v: hMap.keySet()){
            if(hMap.get(v) == min)
                list.add(v);
        }
        
        System.out.println();
        
        for(Integer v: list){
            System.out.println(v);
        }
    }
    
    public static void findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i;        
        
        for(i = 0; i < n; i++) {
            map.put(i, null);
        }
        
        for(i = 0; i < edges.length; i++) {
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            if(map.get(e1) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(e2);
                map.put(e1, list);
            } else {
                map.get(e1).add(e2);
            }
            if(map.get(e2) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(e1);
                map.put(e2, list);
            } else {
                map.get(e2).add(e1);
            }            
        }        
        printMap(map);
        findMinHeightHelper(map, n);
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {0, 3},
            {3, 4},
            {4, 5}
        };
        findMinHeightTrees(n, edges);
    }
}
