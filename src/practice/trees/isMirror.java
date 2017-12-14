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
public class isMirror {
    
    public static TreeNode toMirror(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        else if(root.left == null) {
            root.left = toMirror(root.right);
            root.right = null;
        } else if(root.right == null) {
            root.right = toMirror(root.left);
            root.left = null;
        } else {
            TreeNode t = root.left;
            root.left = toMirror(root.right);
            root.right = toMirror(t);
        }        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];
        for(int i = 0; i < 10 ; i++) {
            node[i] = new TreeNode(i+1);
        }
        node[0].left = node[1];
        node[0].right = node[2];
        node[1].left = node[3];
        node[1].right = node[4];
        node[2].left = node[5];
        node[2].right = node[6];
        node[4].left = node[7];
        node[4].right = node[8];
        node[8].left = node[9];
        System.out.println("before the mirror tree conversion");
        node[0].printTree();
        System.out.println("after the mirror tree conversion");
        node[0] = toMirror(node[0]);
        node[0].printTree();
    }
}
