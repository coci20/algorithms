/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author prasannjitk
 */
public class BFS {
    static public class Graph {
        int n;
        Map<Integer, List<Integer>> map;
        boolean[] visit;
        Graph(int m) {
            n = m;
            map = new HashMap<>();
            for(int i = 0; i < n; i++)
                map.put(i, new ArrayList<>());
            visit = new boolean[m];
        }
        void addEdge(int u, int v) {
            if(map == null || map.isEmpty()) {
                System.out.println("empty graph, add nodes!");
                return;
            }
            map.get(u).add(v);
        }
        
        boolean allCovered() {
            for(int i = 0; i < visit.length; i++) {
                if(!visit[i])
                    return false;
            }
            return true;
        }
        void BFS() {
            visit = new boolean[n];
            System.out.println("printing all    ");
            for(int i = 0; i < n && !allCovered(); i++) {
                if(!visit[i])
                    BFS(i);
            }
        }
        void BFS(int v) {
            if(!map.containsKey(v)) {
                System.out.println("Node " + v + " is not present. Exiting!");
                return;
            }
            visit[v] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(v);
            while(!q.isEmpty()) {
                int t = q.remove();
                System.out.println("Node " + (t+1));
                for (Integer i : map.get(t)) {
                    if(!visit[i]) {
                        q.add(i);
                        visit[i] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 2);
        g.addEdge(3, 4);
        g.addEdge(2, 2);
        g.addEdge(2, 1);
        g.BFS(4);
        g.BFS();
    }
}
