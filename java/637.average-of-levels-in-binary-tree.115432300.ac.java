/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void averageOfLevelsHelper(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> map) {
        if (root != null) {
            if (!map.containsKey(level)) {
                ArrayList<Integer> list = new ArrayList();
                list.add(root.val);
                map.put(level, list);
            } else {
                map.get(level).add(root.val);
            }            
            averageOfLevelsHelper(root.left, level + 1, map);
            averageOfLevelsHelper(root.right, level + 1, map);
        }
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        averageOfLevelsHelper(root, 0, map);
        List<Double> result = new ArrayList<Double>();
        for (int i = 0; i < map.size(); i++){
            double sum = 0;
            for (Integer k:map.get(i)){
                sum += k;
            }
            result.add((double)(sum/(map.get(i).size())));
        }
        return result;
    }
}
