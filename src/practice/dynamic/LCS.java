/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.dynamic;

/**
 *
 * @author prasannjitk
 */
public class LCS {
    public static void lcs (String s1, String s2) {
        int[][] solM = new int[s1.length() + 1][s2.length() + 1];
        int r = solM.length;
        int c = solM[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 || j == 0) {
                    solM[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    solM[i][j] = 1 + solM[i-1][j-1];
                else
                    solM[i][j] = Math.max(solM[i-1][j], solM[i][j-1]);
            }
        }
        System.out.println("lcs(" + s1 + "," + s2 + ")= " + solM[r-1][c-1]);
    }
    public static void main(String[] args) {
        String s1 = "hahau";
        String s2 = "hehahue";       
        lcs(s1, s2);        
    }
}
