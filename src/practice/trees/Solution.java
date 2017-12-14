package practice.trees;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prasannjitk
 */


public class Solution {

   public static void printTree(TreeNode root) {
       if (root != null){
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
   }
   public List<TreeNode> findDuplicateSubtree(TreeNode root){
       List<TreeNode> res = new LinkedList<>();
       postorder(root, new HashMap<>(), res);
       return res;
   } 

    public String postorder(TreeNode cur, HashMap<String, Integer> map, List<TreeNode> res) {
         if (cur == null) return "#";
         String serial = cur.val + "," + postorder(cur.left,map,res) + "," + postorder(cur.right,map,res);
         if (map.getOrDefault(serial, 0) == 1)  res.add(cur);
         
         map.put(serial, map.getOrDefault(serial, 0) + 1);
         System.out.println(serial + " " + map.size());
         return serial;
    }
    
    public static void main(String args[]){
        TreeNode T = new TreeNode(1);
        T.left = new TreeNode(2);
        T.left.left = new TreeNode(4);
        T.right = new TreeNode(3);
        T.right.left = new TreeNode(2);
        T.right.left.left = new TreeNode(4);
        T.right.right = new TreeNode(4);
        
       // printTree(T);
       
       List<TreeNode> res = new Solution().findDuplicateSubtree(T);
       //System.out.println(res.size());
       for (int i=0;i<res.size();i++){
            printTree(res.get(i));
            System.out.println();
       }
        
    }
}