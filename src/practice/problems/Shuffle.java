/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author prasannjitk
 */
public class Shuffle {
    public static void shuffle(int[] cards) {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i < cards.length;) {
            int token = r.nextInt(52) + 1;
            if(!set.contains(token)) {
                cards[i] = token;
                set.add(token);
                i++;
            }
        }
    }
   
    public static void print(int[] cards) {
        for(int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int[] cards =  new int[52];
        for(int i = 0; i < 52; i++) {
            cards[i] = i + 1;
        }
        print(cards);
        shuffle(cards);
        print(cards);
    }
}
