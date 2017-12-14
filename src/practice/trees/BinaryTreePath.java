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
 * @author pprasank
 */
public class BinaryTreePath {
    
    public static void getLeaf(TreeNode root, String s, List<String> list){
        if (root == null) ;
        else if (root.left == null && root.right == null) {
            String str = s + "" + root.val;
            list.add(str);
        } else if (root.left == null) {
            String str = s + "" + root.val + "->";
            getLeaf(root.right, str, list);
        } else if (root.right == null) {
            String str = s + "" + root.val + "->";
            getLeaf(root.left, str, list);
        } else {
            String str = s + "" + root.val + "->";
            getLeaf(root.left, str, list);
            getLeaf(root.right, str, list);
        }
    }
    
    public static List<String> binaryTreePaths(TreeNode root){
        List<String> list = new ArrayList<>();
        String str="";
        getLeaf(root, str, list);
        return list;
    }
    
    public static void main(String[] args) {
        
        TreeNode T = new TreeNode().createBSTSimple();
        T.printTree(); 
        System.out.println(T.height());
        
       
    }
}
