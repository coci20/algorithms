/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author prasannjitk
 */
public class Prim {
    static public class Pair {
        int u, v, dist;
        Pair(int a, int b, int d) {
            u = a;
            v = b;
            dist = d;
        }
    }
    static public class Graph {
        int n;
        List<Pair> pairs;
        Graph(int m) {
            n = m;
            pairs = new ArrayList<>();
        }        
        Comparator<Pair> cmptr = (Pair p1, Pair p2) -> p1.dist - p2.dist;
        void addEdge(int u, int v, int dist) {
            pairs.add(new Pair(u, v, dist));
        }
        Pair hasPair(int u, int v) {
            for(Pair p : pairs) {
                if((p.u == u && p.v == v) ||
                        (p.v == u && p.u == v))
                    return p;
            }
            return null;
        }
        void prims() {
            Set<Integer>[] sets = new Set[2];
            for(int i = 0; i < 2; i++)
                sets[i] = new HashSet<>();
            List<Pair> span = new ArrayList<>();
            Collections.sort(pairs, cmptr);
            sets[0].add(0);
            for(int i = 1; i < n; i++)
                sets[1].add(i);
            while(true) {
                Iterator<Integer> it = sets[0].iterator();
                int index = -1;
                int min = Integer.MAX_VALUE;
                int min_index = -1;
                while(it.hasNext()) {
                    int u = it.next();                    
                    for(Integer v : sets[1]) {
                        Pair p = hasPair(u, v);
                        if(p != null) {
                            min = Math.min(min, p.dist);
                            if(min == p.dist) {
                                min_index = v;
                                index = u;
                            }
                        }
                    }
                }
                span.add(new Pair(index, min_index, min));
                sets[0].add(min_index);
                sets[1].remove(min_index);
                if(sets[0].size() == n)
                    break;                
            }           
            for(int i = 0; i < span.size(); i++) {
                System.out.println(span.get(i).u + " " 
                        + span.get(i).v + " " + span.get(i).dist);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 10);
        g.addEdge(1, 2, 20);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 7);
        g.addEdge(4, 5, 9);
        g.addEdge(5, 0, 4);
        g.addEdge(5, 1, 8);
        g.addEdge(1, 3, 11);
        g.prims();
    }
}
