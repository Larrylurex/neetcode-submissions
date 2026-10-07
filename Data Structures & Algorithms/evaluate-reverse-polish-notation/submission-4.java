class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens) {
            switch(token) {
                case "+", "-", "*", "/" -> {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(switch(token) {
                        case "+" -> op1 + op2;
                        case "*" -> op1 * op2;
                        case "-" -> op1 - op2;
                        default -> op1 / op2;
                    });
                }
                default -> stack.push(Integer.parseInt(token));
            }           
        }
        return stack.pop();
    }
}
