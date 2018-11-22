/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("null");
            return sb.toString();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode t = q.remove();
            if(t != null) {
                sb.append(String.valueOf(t.val));
                q.add(t.left);
                q.add(t.right);
            } else {
                sb.append("null");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(" ");
        if(parts[0].compareTo("null") == 0)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(parts[0]));
        q.add(root);                                  
        int i = 0, index = 0;
        while(true) {            
            if(parts[i].compareTo("null") == 0) {
                i++;
                if(i == parts.length)
                    break;
                continue;
            }
            TreeNode t = q.remove();
            int l = 2 * index + 1;
            if(l == parts.length)
                break;
            int r = 2 * index + 2;
            if(r == parts.length)
                break;
            if(parts[l].compareTo("null") == 0) {
                t.left = null;
            } else {
                t.left = new TreeNode(Integer.valueOf(parts[l]));
                q.add(t.left);
            }
            if(parts[r].compareTo("null") == 0) {
                t.right = null;
            } else {
                t.right = new TreeNode(Integer.valueOf(parts[r]));
                q.add(t.right);
            }
            i++;
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
