class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(char c : s.toCharArray()) {
            char pair = ' ';
            switch (c) {
                case '{', '[', '(':
                    deque.push(c);
                    continue;
                case '}':
                    pair = '{';
                    break;
                case ']':
                    pair = '[';
                    break;
                case ')':
                    pair = '(';
                    break;
                default: return false;
            }
            if(deque.isEmpty() || deque.pollFirst() != pair) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
