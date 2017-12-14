/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.Scanner;

/**
 *
 * @author prasannjitk
 */
public class MonotoneIncreasing {
    @SuppressWarnings("empty-statement")
    public static int printMonotone(int N) {
        String strValue = String.valueOf(N);
        if(strValue.length() <= 1)
            return N;
        char[] digits = strValue.toCharArray();
        int i;
        for(i = 0; i < digits.length - 1; i++) {
            if(digits[i] - '0' > digits[i + 1] - '0')
                break;
        }
        if(i == digits.length - 1)
            return N;
        digits[i++]--;
        while(i < digits.length)
            digits[i++] = '9';
        String res = "";
        for(i = 0; i < digits.length && digits[i] == 0; i++) ;
        
        for(; i < digits.length; i++)
            res += digits[i];
        if(res.length() <= 1)
            return N;
        return printMonotone(Integer.parseInt(res));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(printMonotone(n));
    }
}
