class Solution {
 static final class PrefixTreeNode {
        private final Map<Character, PrefixTreeNode> children = new HashMap<>();
        private boolean word;
    }

    static final class Trie {
        private final PrefixTreeNode root = new PrefixTreeNode();

        void insert(String word) {
            PrefixTreeNode cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(c, k -> new PrefixTreeNode());
            }
            cur.word = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                backtrack(board, r, c, trie.root, str, res);
            }
        }
        return res;
    }

    private void backtrack(char[][] board, int r, int c,
                           PrefixTreeNode node, StringBuilder str, List<String> res) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) return;

        char ch = board[r][c];
        if (ch == '#') return;                      // already on the current path

        PrefixTreeNode next = node.children.get(ch);
        if (next == null) return;                   // dead end: no word continues this way

        str.append(ch);
        if (next.word) {
            res.add(str.toString());
            next.word = false;                      // report each word once
        }

        board[r][c] = '#';
        backtrack(board, r + 1, c, next, str, res);
        backtrack(board, r - 1, c, next, str, res);
        backtrack(board, r, c + 1, next, str, res);
        backtrack(board, r, c - 1, next, str, res);
        board[r][c] = ch;

        str.deleteCharAt(str.length() - 1);
    }
}
