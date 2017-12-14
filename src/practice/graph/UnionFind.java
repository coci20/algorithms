/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author prasannjitk
 */
public class UnionFind {
    static public class Pair {
        int u, v;
        Pair(int a, int b) {
            u = a;
            v = b;
        }
    }
    static public class Graph {
        int n;
        List<Pair> pairs;
        Graph(int m) {
            n = m;
            pairs = new ArrayList<>();
        }
        void hasCycle() {
            Set<Integer>[] set = new Set[n];
            for(int i = 0; i < n; i++) {
                set[i] = new HashSet<>();
                set[i].add(i);
            }
            int i = 0;
            while(i < pairs.size()) {
                Pair p = pairs.get(i);
                boolean flag = true;
                for(Integer v : set[p.v]) {
                    if(set[p.u].contains(v))
                        flag = false;
                }
                if(flag) {
                    set[p.u].addAll(set[p.v]);
                    set[p.v].addAll(set[p.u]);
                }
                else {
                    System.out.println("cycle detected!! on turn " + i);
                    return;
                }
                i++;    
            }
            System.out.println("graph doesn't have a cycle");
        }
        void addEdge(int u, int v) {
            pairs.add(new Pair(u, v));
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(1, 5);
        g.hasCycle();
    }
}
