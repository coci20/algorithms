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
public class DFS {
    static public class Graph {
        int n;
        Map<Integer, List<Integer>> map;
        boolean[] visit;
        Graph(int v) {
            n = v;
            map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            visit = new boolean[n];
        }
        
        void addEdge(int u, int v) {
            if(!map.containsKey(u) || !map.containsKey(v)) {
                System.out.println("invalid input!");
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
        void DFS() {
            visit = new boolean[n];
            System.out.println("printing all nodes      ");
            for(int i = 0; i < n && !allCovered(); i++) {
                if(!visit[i])
                    DFS(i);
            }
        }
        void DFS(int v) {
          if(!map.containsKey(v)) {
              System.out.println("this index is not present! Exiting.");
              return;
          }
          visit[v] = true;
          System.out.println("Node " + v);
          for(Integer i : map.get(v)) {
              if(!visit[i])
                  DFS(i);
          }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(2, 4);
        
        g.DFS(0);
        //g.DFS();
    }
}
