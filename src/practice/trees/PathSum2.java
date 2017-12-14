/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prasannjitk
 */
public class PathSum2 {
    
    public static void sumToLeaf(TreeNode root, String s, List<String> list) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                s += " " + root.val;
                list.add(s);
            } else {
                s += " " + root.val;
                sumToLeaf(root.left, s, list);
                sumToLeaf(root.right, s, list);
            }            
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        TreeNode root = new TreeNode().fullBT();
        sumToLeaf(root, "", list);
        List<List<Integer>> lists = new ArrayList<>();
        for(String ss: list) {
            String[] arr = ss.split(" ");
            List<Integer> t = new ArrayList<>();
            int sum = 0;
            for(String s: arr){
                String sb = s.replaceAll(" ", "");
                if(sb.compareTo("") != 0) {
                    int i = Integer.parseInt(sb);
                    sum += i;
                    t.add(i);
                }
            }
            if(sum == 30)
            lists.add(t);
        }
        for(int i = 0; i < lists.size(); i++) {
            for(Integer n : lists.get(i))
                System.out.print(n + " ");
            System.out.println();
        }
    }
}
