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
import java.util.Stack;

/**
 *
 * @author prasannjitk
 */
public class Dijkstra {
    static public class Pair {
        char a;
        char b;
        int d;
        Pair(char a, char b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }
    static public class Graph {
        int n;
        Map<Character, List<Character>> map;
        List<Pair> pairs;
        Graph(int m) {
            n = m;
            map = new HashMap<>();
            char c = 'A';
            for(int i = 0; i < n; i++)
                map.put(c++, new ArrayList<>());        
        }

        void addEdge(char a, char b, int distance) {
            if(!map.containsKey(a) || !map.containsKey(b)) {
                System.out.println("invalid input! Exiting.");
                return;
            }
            map.get(a).add(b);
            map.get(b).add(a);
            if(pairs == null)
                pairs = new ArrayList<>();
            if (a > b) 
                pairs.add(new Pair(a, b, distance));
            else               
                pairs.add(new Pair(b, a, distance));
            System.out.println("distance(" + a + "," + b +") = " +
                    distance);
        }
        
        Pair getPair(char a, char b) {
            if(a > b) {
                for(Pair p : pairs) {                
                    if(p.a == a && p.b == b)
                        return p;
                } 
            } else {
                for(Pair p : pairs) {                
                    if(p.a == b && p.b == a)
                        return p;
                } 
            }
            return null;
        }
        void dijkstra(char a) {
            if(!map.containsKey(a)) {
                System.out.println("invalid node! Exiting..");
                return;
            }
            System.out.println("running dijkstra for " + a);
            int[] distance = new int[n];
            for(int i = 0; i < n; i++) 
                distance[i] = Integer.MAX_VALUE;
            distance[a - 'A'] = 0;
            Stack<Character> stack = new Stack<>();
            List<Character> list = new ArrayList<>();
            stack.push(a);
            boolean done = false;
            while(!stack.isEmpty()) {
                char v = stack.pop();
                list.add(v);
                int min = Integer.MAX_VALUE;
                char next = v;
                for(Character c : map.get(v)) {
                    if(list.contains(c))
                        continue;
                    Pair p = getPair(v, c);
                    if(p == null)
                        continue;
                    int t = distance[c - 'A'] = Math.min(distance[c - 'A'],
                            distance[v - 'A'] + p.d);
                    min = Math.min(min, t);
                    if(min == t)
                        next = c;                        
                }
                if(next == v)
                        done = true;
                if(!done)
                    stack.push(next);
                else
                    break;
            }
            char t = 'A';
            for(int i = 0; i < n; i++, t++) {
                System.out.println("distance(" + a + "," 
                        + t + ") = " + distance[i]);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge('A', 'B', 10);
        g.addEdge('B', 'C', 20);
        g.addEdge('C', 'D', 5);
        g.addEdge('D', 'E', 7);
        g.addEdge('E', 'F', 9);
        g.addEdge('B', 'D', 11);
        g.addEdge('A', 'F', 4);
        g.addEdge('B', 'F', 8);
        g.dijkstra('A');
        g.dijkstra('E');
    }
}
