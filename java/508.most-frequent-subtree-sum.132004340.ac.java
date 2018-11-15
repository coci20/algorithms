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
    public int populateMap(TreeNode root,
                          Map<Integer, Integer> map) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            if(!map.containsKey(root.val)) {
                map.put(root.val, 1);
            } else {
                int count = map.get(root.val);
                map.put(root.val, count + 1);
            }
            return root.val;
        }
        int rightVal = populateMap(root.right, map);
        int leftVal = populateMap(root.left, map);
        int sum = rightVal + root.val + leftVal;
        if(!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            int count = map.get(sum);
            map.put(sum, count + 1);
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        int k = populateMap(root, map);
        int max = 0;
        for(Integer keys : map.keySet()) {
            max = Math.max(max, map.get(keys));
        }
        List<Integer> list = new ArrayList<>();
        for(Integer keys : map.keySet()) {
            if(map.get(keys) == max)
                list.add(keys);
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}
