class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '{') {
                deque.push('}');
            } else if (c == '(') {
                deque.push(')');
            } else if (c == '[') {
                deque.push(']');
            } else if(deque.isEmpty() || deque.pop() != c) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
