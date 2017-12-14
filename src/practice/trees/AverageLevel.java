/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pprasank
 */
public class AverageLevel {
    
    public static void averageOfLevels(TreeNode root, int level,
            HashMap<Integer, ArrayList<Integer>> map) {
        if (root != null) {
            if (!map.containsKey(level)) {
                ArrayList<Integer> list = new ArrayList();
                list.add(root.val);
                map.put(level, list);
            } else {
                map.get(level).add(root.val);
            }            
            averageOfLevels(root.left, level + 1, map);
            averageOfLevels(root.right, level + 1, map);
        }
    }
    
    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.right = new TreeNode(15);
        n.right.left = new TreeNode(7);
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        averageOfLevels(n, 0, map);
        List<Double> res = new ArrayList<Double>();
        
        for (int i = 0; i < map.size(); i++){
            int sum = 0;
            for (Integer k:map.get(i)){
                sum += k;
            }
            res.add((double)sum/(map.get(i).size()));
        }
        for (Double d:res){
            System.out.println(d);
        }
    }
}
