/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

/**
 *
 * @author pprasank
 */
public class SumLeftLeaves {
    
    public static int print_leaves(TreeNode x, int sum) {
        if (x == null) return 0;
        else if (x.left == null && x.right == null) return x.val;            
        else {            
             print_leaves(x.left, sum);
             sum += x.left.val;
             print_leaves(x.right, sum);
        }
        return sum;
    }
    
    public static void main(String args[]){
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
             
        System.out.println(print_leaves(n, 0));
        
    }
}
