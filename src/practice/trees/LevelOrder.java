/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author prasannjitk
 */
public class LevelOrder {
    
    public static void levelOrder(TreeNode root, List<List<Integer>> lists,
            int level) {
        if(root == null)    return;
        
        List<Integer> list;
        if(lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else
            list = lists.get(level);
        
        list.add(root.val);
        levelOrder(root.left, lists, level+1);
        levelOrder(root.right, lists, level+1);        
    }
    
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root, lists, 0);        
        for(int i = 0; i < lists.size(); i++) {
            for(int j = 0; j < lists.get(i).size(); j++) 
                System.out.println(lists.get(i).get(j));
            System.out.println();
        }
        for(int i = 1; i < lists.size(); i+=2) {
            Collections.reverse(lists.get(i));
        }
        for(int i = 0; i < lists.size(); i++) {
            for(int j = 0; j < lists.get(i).size(); j++) 
                System.out.println(lists.get(i).get(j));
            System.out.println();
        }
    }
}
