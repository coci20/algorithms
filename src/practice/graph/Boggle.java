/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.graph;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author prasannjitk
 */
public class Boggle {
    static String[] dictionary = {
        "GEEKS", 
        "FOR", 
        "QUIZ", 
        "GO"
    };
    static Set<String> set = new HashSet<String>();
    public static String dfs(int i, int j,
            boolean[][] visited,
            char[][] boggle,
            String str, int r, int c) {
        visited[i][j] = true;
        str += boggle[i][j];
        if(set.contains(str))
            System.out.println(str);
        for(int i1 = i - 1; i1 <= i + 1 && i1 < r; i1++) {
            for(int j1 = j - 1; j1 <= j + 1 && j1 < c; j1++)
                if(i1 >= 0 && j1 >= 0 && !visited[i1][j1])
                    str = dfs(i1, j1, visited, boggle, str, r, c);
        }
        visited[i][j] = false;
        str = str.substring(0, str.length() - 1);
        return str;
    }
    public static void findWords(char[][] boggle) {
        int r = boggle.length;
        int c = boggle[0].length;
        for(String s : dictionary)
            set.add(s);
        boolean[][] visited = new boolean[r][c];
        String str = "";
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                str = dfs(i, j, visited, boggle, str, r, c);
            }
        }
    }
    public static void main(String[] args) {
        char[][] boggle = {
            {'G', 'I', 'Z'},
            {'U', 'E', 'K'},
            {'Q', 'S', 'E'}
        };
        findWords(boggle);
    }
}
