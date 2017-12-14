/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.dynamic;

/**
 *
 * @author pprasank
 */
public class DPPalinSubstring {
    
    public static void print_table(boolean[][] table) {
        int n = table.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
            }
        System.out.println();
        }
        
        System.out.println("\n" + "\n");
    }
    public static void main(String[] args){
        String s = "aaaaaaaaaaaaa";
        int n = s.length();
        if (n == 0) System.out.println("empty sing");
        boolean[][] table = new boolean[n][n];
        
        //print_table(table);
        
        int k = 1, maxLen = 1, start = 0;
        for (int i = 0; i < n; i++)
            table[i][i] = true;
        
        for (int i = 0; i < n-1; i++){
            if (s.charAt(i) == s.charAt(i+1)) {
                start = i;
                if (maxLen < 2) maxLen = 2;
                table[i][i+1] = true;
            }
        }
        
        //print_table(table);
        
        for (k = 3; k <= n; k++){
            for (int i = 0; i < n-k+1; i++) {
                int j = i+k-1;
                if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]==true){
                    table[i][j] = true;
                    start = i;
                    if (maxLen < k) maxLen = k;
                }
            }
        }
        
        print_table(table);
        System.out.println(maxLen + " " + start + " " + (start+maxLen-1));
        System.out.println(s.substring(start,start+maxLen));
    }
}
