/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

/**
 *
 * @author prasannjitk
 */
public class PreOrderInOrder {
    
    static int index = 0;
    public static int getRootIn(int[] in, int low, int high, int key) {
        int i;
        if(low >= high)
            return -1;
        for(i = low; i <= high; i++) {
            if(in[i] == key){                
                break;
            }
        }      
        return i;
    }
    
    public static TreeNode buildTreePre(int[] pre, int[] in,
            int[] index, int low, int high){
        if(low > high)
            return null;
        if(low == high) {
            TreeNode root = new TreeNode(pre[index[0]]);
            return root;
        }
        
        TreeNode root = new TreeNode(pre[index[0]]);
        int k = getRootIn(in, low, high, root.val);
        
        if(k > low) {
            index[0]++;
            root.left = buildTreePre(pre, in, index, low, k-1);
        }
        if(k < high) {
            index[0]++;
            root.right = buildTreePre(pre, in, index, k+1, high);
        }
        return root;
    }
    
    public static TreeNode buildTreePost(int[] post, int[] in,
            int[] index, int low, int high){
        if(low > high)
            return null;
        if(low == high) {
            TreeNode root = new TreeNode(post[index[0]]);
            return root;
        }        
        TreeNode root = new TreeNode(post[index[0]]);
        int k = getRootIn(in, low, high, root.val);
        if(k < high) {
            index[0]--;
            root.right = buildTreePost(post, in, index, k+1, high);
        }
        if(k > low) {
            index[0]--;
            root.left = buildTreePost(post, in, index, low, k-1);
        }        
        return root;
    }
    
    public static void printTree(TreeNode root) {
        if(root != null) {            
            printTree(root.left);
            System.out.println(root.val);            
            printTree(root.right);
        }
    }
    
    public static void main(String[] args) {
        int[] pre = {1,2,4,8,9,5,3,6,10,7};
        int[] in = {8,4,9,2,5,1,10,6,3,7};
        int[] post = {8,9,4,5,2,10,6,7,3,1};
        int[] index = new int[1];
        index[0] = 0;
        System.out.println("using pre and in");
        TreeNode root = buildTreePre(pre, in, index, 0, pre.length - 1);
        printTree(root);
        index[0] = post.length - 1;
        System.out.println("using post and in");
        root = buildTreePost(post, in, index, 0, post.length - 1);
        printTree(root);
        double d = 1200.0;
        int m = (int)Math.log10(300.0);
        System.out.println(m);
    }
}
