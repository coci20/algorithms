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
public class Seive {
    /** 
     * prints prime numbers between 2 to n (inclusive) 
     * Print Format: print at most 10 primes per line
     * @param n (number till which primes are
     * to be printed. 
     */
    public static void printPrimes(int n) {
        boolean[] primes = new boolean[n+1];
        for(int i = 0; i <= n; i++) 
            primes[i] = true;
        for(int divisor = 2; divisor * divisor <= n; divisor++) {
            if(primes[divisor]) {
                for(int i = divisor * 2; i <= n; i+=divisor) {
                    primes[i] = false;
                }
            }
        }
        int count  = 0;
        System.out.println("prime nos between 2 and " + n + " are: ");        
        for(int i = 2; i <= n; i++) {
            if(primes[i]) {
                System.out.print(i + "\t");
                count++;
                if(count % 10 == 0)
                System.out.println();
            }            
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of n");
        try{
            String s = reader.readLine();
            int n = Integer.parseInt(s);
            if(n >= 2)
                printPrimes(n);
            
        } catch(IOException ie){
            Logger.getLogger(Seive.class.getName()).log(Level.SEVERE, null, ie);
        }
    }
}
