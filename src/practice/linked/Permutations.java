/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.linked;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author prasannjitk
 */
public class Permutations {
    
    public static void permuteHelper(List<List<Integer>> lists,
            List<Integer> list, List<Integer> copy){
        
        if(list.isEmpty()){
            lists.add(copy);            
        } else {       
        
            int i, j, v;
            
            for(i = 0; i < list.size(); i++) {
                List<Integer> temp = new ArrayList<>(copy);
                List<Integer> rest = new ArrayList<>();
                for(j = 0; j < i; j++) {
                    rest.add(list.get(j));
                }
                for(j = i+1; j < list.size(); j++) {
                    rest.add(list.get(j));
                }            
                v = list.get(i);            
                temp.add(v);
                permuteHelper(lists, rest, temp);      
            }
        }
    }
    
    public static void permute(List<List<Integer>> lists,
            int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i;
        for(i = 0; i < nums.length; i++)
            list.add(nums[i]);
        
        List<Integer> copy = new LinkedList<>();
        permuteHelper(lists, list, copy);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] nums = new int[size];
        for(int i = 1; i <= size; i++){
            nums[i-1] = i;
        }        
        
        List<List<Integer>> lists = new ArrayList<>();
        permute(lists, nums);
        
        for(List<Integer> list: lists) {
            for(Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
