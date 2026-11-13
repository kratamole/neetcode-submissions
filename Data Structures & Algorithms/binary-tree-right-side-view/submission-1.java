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
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<Integer> res = new LinkedList<>();
        queue.offer(root);
        while (true) {
            List<TreeNode> childrenBuffer = new LinkedList<>();
            TreeNode iter;
            do {
                iter = queue.poll();
                if (iter.left != null) {
                    childrenBuffer.add(iter.left);
                }
                if (iter.right != null) {
                    childrenBuffer.add(iter.right);
                }
            } while(!queue.isEmpty());
            res.add(iter.val);
            if (childrenBuffer.isEmpty()) {
                break;
            }
            for (TreeNode child : childrenBuffer) {
                queue.offer(child);
            }
        }
        return res;
    }
}
