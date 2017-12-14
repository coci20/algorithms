/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.dynamic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author prasannjitk
 */
public class LongestCommonSubsequence {
    
    public static void printLCS(int[][] LCS) {
        for(int[] row : LCS) {
            for(Integer j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static int LCS(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        int max = 0;
        int[][] LCS = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(X[i-1] == Y[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;                    
                } else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
                max = Math.max(LCS[i][j], max);                
            }
        }
        int len = 0;
        for(int j = 1; j <= n; j++) {
            for(int i = 1; i <= m; i++) {
                if(LCS[i][j] == (len+1)) {
                    System.out.println(X[i-1]);
                    len++;
                    break;
                }                
            }
            if(len == max)
                break;
        }
        printLCS(LCS);
        return max;
    }
    public static void main(String[] args) {
        String path = "/src/texts/sample.txt";       
        
        String line;
        try(BufferedReader reader = new BufferedReader
                (new FileReader(new File(new File("").getAbsolutePath().concat(path))))){
           line = reader.readLine();
           int m = Integer.parseInt(line.split(" ")[0]);
           int n = Integer.parseInt(line.split(" ")[1]);
           line = reader.readLine();
           String[] first = line.split(" ");
           int[] X = new int[m];
           for(int i = 0; i < m; i++) {
               X[i] = Integer.parseInt(first[i]);
           }
           int[] Y = new int[n];
           line = reader.readLine();
           String[] second = line.split(" ");
           for(int i = 0; i < n; i++) {
               Y[i] = Integer.parseInt(second[i]);
           }
           System.out.println("LCS of X and Y is: " + LCS(X, Y));
           reader.close();
        }
        catch(IOException ie) {
                System.err.println(ie.getMessage());
        }    
    }
}
