class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rightMax = new int[heights.length];
        Deque<Integer> rightStack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++) {
            while(!rightStack.isEmpty() && heights[i] < heights[rightStack.peek()]) {
                Integer popped = rightStack.pop();
                rightMax[popped] = i - popped;
            }
            rightStack.push(i);
        }

        int[] leftMax = new int[heights.length];
        Deque<Integer> leftStack = new ArrayDeque<>();
        for(int i = heights.length - 1; i >= 0 ; i--) {
            while(!leftStack.isEmpty() && heights[i] < heights[leftStack.peek()]) {
                Integer popped = leftStack.pop();
                leftMax[popped] = popped - i;
            }
            leftStack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int right = (rightMax[i] == 0) ? heights.length - i :  rightMax[i];
            int left = (leftMax[i] == 0) ? i + 1 : leftMax[i];
            int area = (left + right - 1) * heights[i];
            max = Math.max(max , area);
        }
        return max;
    }
}
