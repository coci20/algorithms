/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author prasannjitk
 */
public class FloydWarshall {
    static public class Pair {
        int a, b, distance;
        Pair(int u, int v, int d) {
            a = u;
            b = v;
            distance = d;
        }
    }
    static public class Graph {
        int n;
        Map<Integer, List<Integer>> map;
        List<Pair> pairs;
        Graph(int m) {
            map = new HashMap<>();
            n = m;
            for(int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
        }        
        void addEdge(int u, int v, int distance) {
            if(!map.containsKey(u) || !map.containsKey(v)) {
                System.out.println("invalid entry! Exiting.");
                return;
            }
            map.get(u).add(v);
            if(pairs == null)
                pairs = new ArrayList<>();
            pairs.add(new Pair(u, v, distance));
        }
        
        Pair getPair(int u, int v) {
            for(Pair p : pairs) {
                if(p.a == u && p.b == v)
                    return p;
            }
            return null;
        }
        void floydWarshall() {
            List<List<Integer>> lists = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int[] nums = new int[n];
                for(int j = 0; j < n; j++) {
                    nums[j] = Integer.MAX_VALUE;                    
                }
                nums[i] = 0;
                List<Integer> done = new ArrayList<>();
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while(!stack.isEmpty()) {
                    int v = stack.pop();
                    done.add(v);
                    int next = v;
                    int min = Integer.MAX_VALUE;
                    for(Integer m : map.get(v)) {
                        if(done.contains(m))
                            continue;
                        Pair p = getPair(v, m);
                        if(p == null)
                            continue;
                        int t = nums[m] = Math.min(nums[m],
                                nums[v] + p.distance);
                        min = Math.min(min, t);
                        if(min == t)
                            next = m;
                    }
                    if(next == v)
                        break;
                    stack.push(next);
                }
                List<Integer> sub = new ArrayList<>();
                for(int k = 0; k < n; k++)
                    sub.add(nums[k]);
                lists.add(sub);
            }
            for(List<Integer> L : lists) {
                System.out.println(Arrays.toString(
                        L.toArray(new Integer[L.size()])));
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(0, 3, 10);
        g.floydWarshall();
    }
}
