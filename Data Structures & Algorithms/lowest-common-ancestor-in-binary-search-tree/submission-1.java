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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Deque<TreeNode> stackP = new ArrayDeque<>();
        Deque<TreeNode> stackQ = new ArrayDeque<>();

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(stackP.peek() != p) stackP.push(node);
            if(stackQ.peek() != q) stackQ.push(node);

            if(node.left == null && node.right == null) {
                if(stackP.peek() != p) {
                    while(!stackP.isEmpty() && stackP.peek().left != stack.peek() && stackP.peek().right != stack.peek()) {
                        stackP.pop();
                    }
                }
                if(stackQ.peek() != q) {
                    while(!stackQ.isEmpty() && stackQ.peek().left != stack.peek() && stackQ.peek().right != stack.peek()) {
                        stackQ.pop();
                    }
                }
            }

            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        while(!stackQ.isEmpty() || !stackP.isEmpty()) {
            if(stackP.peek() == stackQ.peek()) return stackP.peek();
            if(stackQ.size() > stackP.size()){
                stackQ.pop();
            }else {
                stackP.pop();
            }
        }
        return null;
    }
}
