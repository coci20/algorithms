/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prasannjitk
 */
public class PascalTriangle {
    /**
     * printing the Pascal's Triangle, which shows
     * the application of a 2D array
     * @param n : number of rows
     */
    public static void printPascals(int n){
        int[][] pascals = new int[n+1][];
        for(int i = 0; i < n; i++) {
            pascals[i] = new int[i+1];
            pascals[i][0] = 1;
            for(int j = 1; j < i; j++) {
                pascals[i][j] = pascals[i-1][j-1] + pascals[i-1][j];
            }
            pascals[i][i] = 1;
        }
        
        //System.out.println(Arrays.deepToString(Arrays.asList(pascals).toArray()));
        
        for(int[] row : pascals) {
            if(row == null)
                continue;
            for(int j = 0; j < pascals.length - row.length - 1; j+=2)
                System.out.print("\t");            
            for(int i = 0; i < row.length; i++) {                
                System.out.print(row[i] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of n");
        try{
            String s = reader.readLine();
            int n = Integer.parseInt(s);
            printPascals(n);    
            
        } catch(IOException ie){
            Logger.getLogger(Seive.class.getName()).log(Level.SEVERE, null, ie);
        }
    }
}
