class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for(String token: tokens) {
            if( "+".equals(token)) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(op1 + op2));
            } else if( "*".equals(token)) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(op1 * op2));
            } else if( "-".equals(token)) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(op1 - op2));
            } else if( "/".equals(token)) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(op1 / op2));
            } else {
                stack.push(token);
            }
        }
        return  Integer.parseInt(stack.pop());
    }
}
