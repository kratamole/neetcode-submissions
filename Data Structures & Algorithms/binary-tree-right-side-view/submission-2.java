/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new LinkedList<>();
        List<TreeNode> curLayer = new LinkedList<TreeNode>();
        curLayer.add(root);
        while (true) {
            List<TreeNode> nextLayer = new LinkedList<>();
            TreeNode iter;
            do {
                iter = curLayer.removeFirst();
                if (iter.left != null) {
                    nextLayer.add(iter.left);
                }
                if (iter.right != null) {
                    nextLayer.add(iter.right);
                }
            } while(!curLayer.isEmpty());
            res.add(iter.val);
            if (nextLayer.isEmpty()) {
                break;
            } else {
                curLayer = nextLayer;
            }
        }
        return res;
    }
}
