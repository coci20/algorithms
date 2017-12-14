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
public class PrintBinaryTree {
    
    public static void printTree(TreeNode root,
            List<List<String>> lists, int level) {
        
        
        
        if(root == null)    {
            return;
        }
        
        for(int i = 0; i < level; i++) {
            for(int j = i; j < level; j++)
                lists.get(i).add("*");
        }
        
        List<String> mylist;
        if(lists.size() == level){
           mylist = new ArrayList<>();
           lists.add(mylist);
        } else{
            mylist = lists.get(level);
        }
        printTree(root.left, lists, level + 1);
        mylist.add(String.valueOf(root.val));
        printTree(root.right, lists, level + 1);
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode().completeBT();
        List<List<String>> lists = new ArrayList<>();
        printTree(root, lists, 0);
        for(List<String> l : lists) {
            for(String s : l)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
