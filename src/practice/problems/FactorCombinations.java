/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author prasannjitk
 */
public class FactorCombinations {
    public static List<Integer> getFactors(int n, List<List<Integer>> lists) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) {
                list.add(i);
                list = getFactors(n/i, lists);
            }
        }
        lists.add(list);
        return list;
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            List<List<Integer>> lists = new ArrayList<>();
            getFactors(n, lists);
        }
    }
}


/*
n = 24

L1 : 2

n = 12

L2 : 2

n = 6

L3 : 2

n = 3
L4 : null

*/

