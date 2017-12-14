/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prasannjitk
 */
public class IslandsProblem {
    public static void dfs (int[][] board,
            boolean[][] visited, int i, int j,
            List<int[]> list) {
        visited[i][j] = true;
        for(int r = i - 1; r < board.length 
                && r <= i + 1; r++) {
            for(int c = j - 1; c < board[i].length
                    && c <= j + 1; c++) {
                if(r < 0 || c < 0)
                    continue;
                if(r == i && c == j)
                    continue;
                if(!(Math.abs(r - i) + Math.abs(c - j) == 1))
                    continue;
                if(!visited[r][c] && board[r][c] == 1) {
                    list.add(new int[]{r, c});
                    dfs(board, visited, r, c, list);
                } else if(board[r][c] == 0)
                    visited[r][c] = true;
            }
        }
    }
    public static void print(int i, int j, List<int[]> list) {
        System.out.println("for i = " + i + " for j = " + j);
        for(int[] p : list) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
    public static void main(String[] args) {
        int[][] board = {
            {1,0,0,1,0,0,0},
            {1,0,0,1,0,0,0},
            {1,1,1,1,1,1,1},
            {0,0,0,1,0,0,1},
            {1,1,1,1,0,0,1}
        };
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = 
                new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(visited[i][j])
                    continue;
                if(board[i][j] == 1) {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i , j});
                    dfs(board, visited, i, j, list);
                    print(i, j, list);
                } else {
                    visited[i][j] = true;
                }
            }
        }
    }
}
