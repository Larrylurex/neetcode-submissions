class Solution {
static final class PrefixTreeNode {
        private final Map<Character, PrefixTreeNode> children;
        private boolean word;

        private boolean found;


        PrefixTreeNode(Map<Character, PrefixTreeNode> children) {
            this.children = children;
        }

        public Map<Character, PrefixTreeNode> children() {
            return children;
        }

        public boolean word() {
            return word;
        }
    }

    class Trie {
        private PrefixTreeNode root;

        public Trie() {
            root = new PrefixTreeNode(new HashMap<>());
        }

        public void insert(String word) {
            PrefixTreeNode cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new PrefixTreeNode(new HashMap<>()));
                cur = cur.children.get(c);
            }
            cur.word = true;
        }

        public boolean search(String word) {
            PrefixTreeNode cur = root;
            for (char c : word.toCharArray()) {
                PrefixTreeNode node = cur.children.get(c);
                if (node == null) return false;
                cur = node;
            }
            if(cur.word && !cur.found) {
                cur.found = true;
                return true;
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            PrefixTreeNode cur = root;
            for (char c : prefix.toCharArray()) {
                PrefixTreeNode node = cur.children.get(c);
                if (node == null) return false;
                cur = node;
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new ArrayList<>();
        int rows = board.length;
        int columns = board[0].length;
        for(int i = 0; i < rows * columns; i++) {

            StringBuilder str = new StringBuilder();
            backtrack(board, i / columns,i % columns, trie, str, res);
        }
        return res;
    }

    private void backtrack(char[][] board, int r, int c, Trie trie, StringBuilder str, List<String> res) {

        if(!trie.startsWith(str.toString())) return;

        str.append(board[r][c]);
        if(trie.search(str.toString())) {
            res.add(str.toString());
        }
        board[r][c] = '#';
        if(r + 1 < board.length && board[r + 1][c] != '#') {
            backtrack(board, r + 1, c, trie, str, res);
        }
        if(r - 1 >= 0 && board[r - 1][c] != '#') {
            backtrack(board, r - 1, c, trie, str, res);
        }
        if(c + 1 < board[r].length && board[r][c + 1] != '#') {
            backtrack(board, r, c + 1, trie, str, res);
        }
        if(c - 1 >= 0 && board[r][c - 1] != '#') {
            backtrack(board, r, c - 1, trie, str, res);
        }
        board[r][c] = str.charAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
    }
}
