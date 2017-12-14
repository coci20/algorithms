/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author prasannjitk
 */
public class ThreeSum {
    
    public static void findTarget(int[] nums, int index, int key,
        Set<List<Integer>> sets){
        List<Integer> list = new ArrayList<>();
        int i, j;
        for(i = 0; i < nums.length; i++) {
            if(i == index)
                continue;
            list.add(nums[i]);
        }

        Collections.sort(list);

        i = 0;
        j = list.size() - 1;

        while(i < j) {
            int sum = list.get(i) + list.get(j);
            if(sum == key) {
                List<Integer> L = new ArrayList<>();
                L.add(list.get(i));
                L.add(list.get(j));
                L.add(-key);
                Collections.sort(L);
                sets.add(L);
                
                i++;
                j--;
            }                
            else if(sum > key)
                j--;
            else {
                i++;
            }
        }    
    }
    
    public static void threeSum(int[] nums) {
        Set<List<Integer>> sets = new HashSet<>();
        int i;
        for(i = 0; i < nums.length; i++) { 
            findTarget(nums, i, -nums[i], sets);
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(List<Integer> list : sets) {
            lists.add(list);
        }
        
        for(List<Integer> list : lists) {
            for(i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[] S = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        threeSum(S);
    }
}
