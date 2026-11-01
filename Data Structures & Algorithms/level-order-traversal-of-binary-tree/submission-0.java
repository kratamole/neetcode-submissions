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
    List<List<Integer>> accum = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.recFunc(root, 0);
        return this.accum;
    }

    private void recFunc(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        List<Integer> levelList;
        if (level >= this.accum.size()) {
            levelList = new LinkedList<>();
            this.accum.add(levelList);
        } else {
            levelList = this.accum.get(level);
        }
        levelList.add(node.val);
        this.recFunc(node.left, level + 1);
        this.recFunc(node.right, level + 1);
    }
}
