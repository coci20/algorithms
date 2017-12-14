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
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    static int size = 0;
    
    public TreeNode(int x) {
        val = x;
    }
    
    public TreeNode() {
        
    }
    
    /* 
     * BST : A binary tree where the current node is greater than equal
     * to left descendents and less than its right descendernts
     */
    public TreeNode createBSTSimple() {
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(4);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(5);
        t.right = new TreeNode(15);
        t.right.left = new TreeNode(12);
        t.right.left.right = new TreeNode(13);
        t.right.left.right.right = new TreeNode(14);
        return t;
    }
    
    /*
     * FBT(Full Binary Tree) : A tree that 
     * has 0 or 2 nodes
     */
    public TreeNode fullBT(){
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(14);
        t.left.left = new TreeNode(21);
        t.left.right = new TreeNode(52);
        t.right = new TreeNode(15);
        t.right.right = new TreeNode(17);
        t.right.left = new TreeNode(2);
        t.right.left.right = new TreeNode(13);
        t.right.left.left = new TreeNode(3);        
        return t;
    }
    
    /*
     * CBT(Complete Binary Tree): A tree that has
     * all but the last level filled
     */
    public TreeNode completeBT(){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(4);
        t.left.left = new TreeNode(2);
        t.left.left.left = new TreeNode(8);
        t.left.left.left.left = new TreeNode(6);
        t.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.right.right = new TreeNode(9);
        return t;
    }
    
    public int getSize() {
        getSize(this);
        return size;
    }
    
    private void getSize(TreeNode t){
        if(t != null) {
            size++;
            getSize(t.left);
            getSize(t.right);
        }
    }
    
    public void printTreeInOrder() {
        printTreeInOrder(this);
    }
    
    private void printTreeInOrder(TreeNode t) {
        if(t != null) {
            printTreeInOrder(t.left);
            System.out.println(t.val);
            printTreeInOrder(t.right);
        }
    }
    
    public void printTreePostOrder() {
        printTreePostOrder(this);
    }
    
    private void printTreePostOrder(TreeNode t) {
        if(t != null) {
            printTreePostOrder(t.left);            
            printTreePostOrder(t.right);
            System.out.println(t.val);
        }
    }
    
    public void printTreePreOrder() {
        printTreePreOrder(this);
    }
    
    private void printTreePreOrder(TreeNode t) {
        if(t != null) {            
            System.out.println(t.val);
            printTreePreOrder(t.left);
            printTreePreOrder(t.right);
        }
    }
    
    public void printTree() {
        List<List<Integer>> lists = new ArrayList<>();        
        printTree(this, lists, 0);
        System.out.println("[");
        for(List<Integer> l : lists) {
            System.out.print("[");
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.print("]\n");
        }
        System.out.println("]\n");
    }
    
    private void printTree(TreeNode root, List<List<Integer>> lists, int level) {
        List<Integer> list;
        if(lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        if(root == null) {
            list.add(-1);
        } else {
            list.add(root.val);
            printTree(root.left, lists, level + 1);
            printTree(root.right, lists, level + 1);
        }
    }
    
    private int getInSuccessor(TreeNode root) {
        if(root.right != null) {
             return getInSuccessor(root.right);
        }
        return root.val;
    }
    
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)   return root;
        
        if(key < root.val) {
            root.left = deleteNode(root.left, key);            
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            else {
                root.val = getInSuccessor(root.left);
                root.left = deleteNode(root.left, root.val);    
            }
        }        
        return root;
    }
    
    private TreeNode deleteThisNode(TreeNode root, TreeNode n) {
        if(n == null)   return null;
        if(n.left == null) {
            n = n.right;
        } else if(n.right == null) {
            n = n.left;            
        } else {
            n.val = getInSuccessor(n.left);
            n.left = deleteThisNode(n.left, n.left.getNode(n.val));            
        }
        return root;
    }
    
    public TreeNode deleteRec(int key) {        
        return this.deleteNode(this, key);
    }
    
    private TreeNode getNode(int key) {
        TreeNode root = this;
        if(root.val == key)
            return root;
        if(root.val < key) {
            return root.right.getNode(key);
        } else
            return root.left.getNode(key);
    }
    
    public TreeNode trimNode(int key) {
        TreeNode n = getNode(key);
        return deleteThisNode(this, n);
    }
    
    public int height(){
        return this.height(this);
    }
    private int height(TreeNode root) {
        if(root == null)    return -1;
        return 1 + Math.max(height(root.left),height(root.right));
    }
}
