/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prasannjitk
 */
public class Topo {

    /**
     *
     */
    static public class Graph {
        int n;
        Map<Integer, List<Integer>> map;
        Graph(int m) {
            n = m;
            map = new HashMap<>();
            for(int i = 0; i < n; i++)
                map.put(i, new ArrayList<>());
        }
        void addEdge(int u, int v) {
            if(!map.containsKey(u) || !map.containsKey(v))
                return;
            map.get(u).add(v);
        }
        boolean covered(boolean[] order) {
            for(int i = 0; i < order.length; i++) {
                if(!order[i])
                    return false;
            }
            return true;
        }
        void topo() {
            System.out.println("printing elements in topological"
                    + "order");
            boolean[] order = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(!map.containsKey(i)) {
                    order[i] = true;
                    System.out.println(i);
                }
            }            
            while(!covered(order)) {
                for(Integer i : map.keySet()) {
                    if(order[i])
                        continue;
                    for(int j = 0; j < n; j++) {
                        if(map.get(i).contains(j)) {
                            if(order[j])
                                map.get(i).remove(map.get(i).indexOf(j));
                        }
                    }                    
                    if(map.get(i).isEmpty()) {
                        order[i] = true;
                        System.out.println(i);
                    }
                }
            }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(3, 1);
        g.addEdge(2, 3);
        g.addEdge(5, 2);
        g.topo();
    }
}
