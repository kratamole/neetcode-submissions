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
    public boolean isValidBST(TreeNode root) {
        return recValidation(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recValidation(TreeNode node, int lessThan, int greaterThan) {
        if (node == null) {
            return true;
        }
        if (!(lessThan < node.val && greaterThan > node.val)) {
            return false;
        }
        return recValidation(node.left, lessThan, node.val) 
            && recValidation(node.right, node.val, greaterThan);
    }
}
