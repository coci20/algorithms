/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

/**
 *
 * @author prasannjitk
 */
public class ValidPalindrome {
    
    public static boolean validPalin(){
        String s = "temaebcabbacbamet";
        int i, j;
        i = 0;
        j = s.length() - 1;
        int count = 0;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if(count < 1 && s.charAt(i + 1) == s.charAt(j)) {
                    count++;
                    i++;
                } else
                    return false;
            }
        }
        return (i > j); 
        
    }
    
    public static void main(String[] args) {
        System.out.println(validPalin());
    }
}
