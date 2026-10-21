class WordDictionary {

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



    public WordDictionary() {
        root = new PrefixTreeNode(new HashMap<>());
    }

    public void addWord(String word) {
        PrefixTreeNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new PrefixTreeNode(new HashMap<>()));
            cur = cur.children.get(c);
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return search(root, 0, word);
    }
    private  boolean search(PrefixTreeNode r, int startIdx, String word) {
        PrefixTreeNode cur = r;
        char[] charArray = word.toCharArray();
        for (int i = startIdx, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (c == '.') {
                for (PrefixTreeNode child : cur.children.values()) {
                    if(search(child, i + 1, word)) return true;
                }
                return false;
            }
            PrefixTreeNode node = cur.children.get(c);
            if (node == null) return false;
            cur = node;
        }
        return cur.word;
    }
}
