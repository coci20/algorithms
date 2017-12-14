/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author prasannjitk
 */
public class TopoSort {
    public static String topoSort(int n, int[][] AM) {
        boolean[] visited = new boolean[n];
        int[] indeg = new int[n];
        int l1 = AM.length;
        for(int i = 0; i < l1; i++) {
            for(int j = 0; j < l1; j++) {
                if(AM[i][j] == 1)
                    indeg[j] += 1;
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indeg[i] == 0) {
                Q.add(i);
                visited[i] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!Q.isEmpty()) {
            int t = Q.peek();
            list.add(Q.remove() + 1);
            for(int i = 0; i < n; i++) {
                if(visited[i])
                    continue;
                if(AM[t][i] == 1) {
                    indeg[i]--;
                    if(indeg[i] == 0) {
                        Q.add(i);
                        visited[i] = true;
                    }
                }    
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(String.valueOf(i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        int n = Integer.valueOf(line.split(" ")[0]);
        int m = Integer.valueOf(line.split(" ")[1]);
        int[][] edges = new int[m][2];
        for(int i = 0; i < m; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        
        }
        int[][] AM = new int[n][n];
        for(int i = 0; i < m; i++) {
            AM[edges[i][0] - 1][edges[i][1] - 1] = 1;
        }
        System.out.println(topoSort(n, AM));
    }
}
