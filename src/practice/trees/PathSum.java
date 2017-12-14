/*
 You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
package practice.trees;

import java.util.ArrayList;

/**
 *
 * @author prasannjitk
 */
public class PathSum {
    
    public static void rootSum(TreeNode root,
                    int sum, ArrayList<Integer> list,
                    int key, int[] count) {
        if (root != null) {
            if(root.left == null && root.right == null) {
                sum += root.val;
                list.add(sum);
            } else {
                sum += root.val;
                if (sum == key)
                    count[0]++;
                if(root.left != null) {                    
                    rootSum(root.left, sum, list, key, count);
                }
                if(root.right != null) {
                    rootSum(root.right, sum, list, key, count);
                }
            }
        }
    }
    
    public static void pathSumHelper(TreeNode root, int sum,
                            int[] count) {
        if(root != null) {
            ArrayList<Integer> sublist =
                new ArrayList<>();
            rootSum(root, 0, sublist, sum, count);
            for(int i = 0; i < sublist.size(); i++) {
                System.out.println(sublist.get(i));
                if(sublist.get(i) == sum)
                    count[0]++;
            }
            pathSumHelper(root.left, sum, count);
            pathSumHelper(root.right, sum, count);
        }
    }
    
    public static int pathSum(TreeNode root, int sum) {        
        int[] count = new int[1];
        count[0] = 0;
        pathSumHelper(root, sum, count);
        return count[0];
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        
        int sum = 8;
        System.out.println(pathSum(root, sum));
    }
}
