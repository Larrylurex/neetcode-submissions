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
        List<Integer> sorted = new ArrayList<>();
        ordered(root, sorted);

        return sorted.get(k - 1);
    }

    void ordered(TreeNode node, List<Integer> sorted) {
        if (node == null) return;

        ordered(node.left, sorted);
        sorted.add(node.val);
        ordered(node.right, sorted);
    }
}
