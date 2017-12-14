/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prasannjitk
 * 
 * KMP Search Algorithm : based on creating a deterministic
 * finite automaton of the pattern (to avoid looking at the
 * backed up string) while searching in the text pattern.
 * 
 * Steps:
 * 1) Open the file to read.
 * 2) Read the search pattern from the user.
 * 3) Write the function to search for the pattern
 *      given the text string.
 */
public class KMPSearch {
    
    /**
     * to create the dfs matrix, get the number of
     * unique characters in the pattern and use it as
     * row index, the pattern characters form the
     * column index.
     * 1) copy mismatch
     * 2) set matches
     * 3) update mismatch
     * @param pattern to be searched in the text.
     * @param dfs : populate the dfs matrix
     * @param M : number of characters in pattern
     * @param R : alphabet size
     */
    public static void createDFS(String pattern,
            int[][] dfs, int M, int R) {
        dfs[pattern.charAt(0)-'a'][0] = 1;
        int X, j;
        for(j = 1, X = 0; j < M; j++) {
            for(int c = 0; c < R; c++) 
                dfs[c][j] = dfs[c][X];
            dfs[pattern.charAt(j) - 'a'][j] = j + 1;
            X = dfs[pattern.charAt(j) - 'a'][X];
        }
    }    
    
    /**
     * When we are searching through the text, i doesn't 
     * get decremented, while j is updated as per the dfs.
     * 
     * @param text : get the length
     * @param pattern : get the number of unique characters
     */
    public static void searchString(String text, String pattern){
        int N = text.length();
        int M = pattern.length();
        int R = 26;
        int[][] dfs = new int[R][M];
        createDFS(pattern, dfs, M, R);
        int i, j;
        for(i = 0, j = 0; i < N && j < M; i++) {
            char c = text.charAt(i);
            if(c >= 'A' && c <= 'Z')
                c = (char) ('a' + (c - 'A'));
            if(c >= 'a' && c <= 'z')
                j = dfs[c-'a'][j];
        }
        if(j == M)
            System.out.println("pattern is present at " + (i-M));
        else
            System.out.println("pattern is not present in this text");
    }
    
    public static boolean validPattern(String pattern) {
        int i;
        for(i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!(c >= 'a' && c <= 'z')) 
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String path = "/src/texts/test_kmp.txt";
        File file = new File(new File("").getAbsolutePath().concat(path));
        System.out.println("text string is test_kmp.txt");
        try (FileReader reader = new FileReader(file)){
            System.out.println("enter the pattern string to search");
            BufferedReader br = new BufferedReader
                    (new InputStreamReader(System.in));
            String pattern = br.readLine();
            if(!validPattern(pattern)) {
                System.out.println("only lower-case allowed");
                reader.close();
                System.exit(0);
            }
            br = new BufferedReader(reader);
            String line;
            StringBuilder text = new StringBuilder();
            while((line = br.readLine()) != null) {
                text.append(line);
            }
            if(pattern.length() != 0)
                searchString(text.toString(), pattern);
            else
                System.out.println("pattern can't be empty");
        } catch (Exception e) {
            Logger.getLogger(KMPSearch.class.getName()).log(Level.SEVERE, null, e);
        }        
    }
}
