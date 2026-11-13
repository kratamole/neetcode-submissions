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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedValues = new ArrayList<>();
        this.traverseTree(root, sortedValues, k);
        return sortedValues.get(k-1);
    }


    private void traverseTree(TreeNode node, List<Integer> values, int targetSize) {
        if (node == null) {
            return;
        }
        if (values.size() >= targetSize) {
            return;
        }
        this.traverseTree(node.left, values, targetSize);
        values.add(node.val);
        this.traverseTree(node.right, values, targetSize);
    }
}
