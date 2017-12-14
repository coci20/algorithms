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
 * @author pprasank
 */
public class Atoi {
    public static void main(String[] args) {
        String str = "2147483648";
        if (not_valid(str)) System.out.println("not acceptable");
        
        List<Integer> ilist = new ArrayList<>();
        int i = 0;
        int len = str.length();
        
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        if(i == len) return ;
        
        int sign = 1;
        
        char k = str.charAt(i);
        
        if (k == '-' || k == '+') {
            i++;
            if (k == '-') sign  = -1;                
        }
        
        if (i == str.length()) return ;
        
        while (i < str.length() && (str.charAt(i) - '0' >= 0) && (str.charAt(i) - '0' <= 9)) {
            ilist.add(str.charAt(i) - '0');
            System.out.println("adding " + str.charAt(i));
            i++;
        }
        
        int sum = 0;
        int p = sum;
        for (i = 0; i < ilist.size(); i++) {
            p = sum;
            sum = sum*10 + ilist.get(i);
            if ((sum - ilist.get(i))/10 != p) {
                System.out.println("overflow!!");
                if (sign == -1)
                    System.out.println(Integer.MIN_VALUE);
                else
                    System.out.println(Integer.MAX_VALUE);
            }                
        }

        if (sum < 0 && sign == 1)   System.out.println(Integer.MAX_VALUE);
        if (sum < 0 && sign == -1)  System.out.println(Integer.MIN_VALUE);
        
        if (sign == -1) sum = sign * sum;
        
        System.out.println(sum);
    }

    private static boolean not_valid(String str) {
        
        return false;
    }
}
