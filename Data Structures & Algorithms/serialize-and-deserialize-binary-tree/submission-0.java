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

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        write(root, res);
        return res.toString();
    }

    void write(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null");
            return;
        }
        res
                .append(root.val)
                .append(',')
                .append(serialize(root.left))
                .append(',')
                .append(serialize(root.right));
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return build(tokens);
    }

    private TreeNode build(Queue<String> tokens) {
        String token = tokens.poll();
        if ("null".equals(token)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left  = build(tokens);
        node.right = build(tokens);
        return node;
    }
}
