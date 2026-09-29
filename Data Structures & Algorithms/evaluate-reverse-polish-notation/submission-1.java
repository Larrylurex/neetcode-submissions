class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            if(!isOperator(t)) {
                stack.push(Integer.parseInt(t));
            } else {
                int left = stack.pop();
                int right = stack.pop();
                int res = calc(right, left, t);
                stack.push(res);
            }
        }
        return stack.getLast();
    }

     private boolean isOperator(String t) {
        List<String> ops = List.of("+", "-","*","/");
        return ops.contains(t);
    }

    private int calc(int right, int left, String op) {
        switch(op) {
            case "+": return right + left;
            case "-": return right - left;
            case "*": return right * left;
            default: return right / left;
        }
    }
}
