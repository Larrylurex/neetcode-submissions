class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(min.getFirst(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.getFirst();
    }
    
    public int getMin() {
        return min.getFirst();
    }
}
