/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author prasannjitk
 */
public class QueueReconst {
    public static void main(String[] args) {
        int[][] nums = {
            {7,0},
            {4,4},
            {7,1},
            {5,0},
            {6,1},
            {5,2}
        };
        Comparator<int[]> comptr = 
                (int[] a, int[] b) -> {
                  return a[0] != b[0] ? -a[0] + b[0] : a[1] - b[1];  
                };
        Arrays.sort(nums, comptr);
        for(int[] p : nums) {
            System.out.println(p[0] + " " + p[1]);
        }
        List<int[]> list = new LinkedList<>();
        for(int[] p : nums) {
            list.add(p[1], p);
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.println(
                    list.get(i)[0] + 
                    " " + 
                    list.get(i)[1]);
        }
        nums = list.toArray(new int[nums.length][]);
        for(int[] p : nums) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}
