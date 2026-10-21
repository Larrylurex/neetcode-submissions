class PrefixTree {
    

    static final class PrefixTreeNode {
        private final Map<Character, PrefixTreeNode> children;
        private boolean word;

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

    private PrefixTreeNode root;
    public PrefixTree() {
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
            if(node == null) return false;
            cur = node;
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode cur = root;
        for (char c : prefix.toCharArray()) {
            PrefixTreeNode node = cur.children.get(c);
            if(node == null) return false;
            cur = node;
        }
        return true;
    }
}
