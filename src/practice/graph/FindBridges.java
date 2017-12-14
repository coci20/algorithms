/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author prasannjitk
 */
public class FindBridges {
    static public class Graph {
        int n;
        Map<Integer, List<Integer>> map;
        boolean[] visit;
        Graph(int size) {
            n = size;
            map = new HashMap<>();
            for(int i = 0; i < n ; i++)
                map.put(i, new ArrayList<>());
            visit = new boolean[n];
        }
        void addEdge(int u, int v) {
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean allCovered() {
            for(int i = 0; i < n; i++) {
                if(!visit[i])
                    return false;
            }
            return true;
        }
        void checkBridge() {
            Queue<Integer> q = new LinkedList<>();
            for(Integer k : map.keySet()) {
                if(!map.get(k).isEmpty()) {
                    if(map.get(k).size() == 1) {
                        q.add(k);
                        q.add(map.get(k).get(0));
                        visit[k] = true;
                        visit[map.get(k).get(0)] = true;
                    }
                }
            }
            while(!q.isEmpty()) {
                int v = q.remove();
                visit[v] = true;
                if(map.get(v).isEmpty())
                    continue;
                for(int j = 0; j < n; j++) {
                    if(map.get(v).contains(j)) {
                        if(visit[j])
                            map.get(v).remove(map.get(v).remove(
                                    map.get(v).indexOf(j)));
                        else
                            q.add(j);
                    }
                }
            }
            System.out.println("after removing the bridges");
            for(Integer i : map.keySet()) {
                System.out.println(i + " : " + Arrays.toString(map.get(i).toArray()));
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 6);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.checkBridge();
    }
}
