class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        Arrays.fill(rightMax, heights.length);
        Arrays.fill(leftMax, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                rightMax[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = heights.length - 1; i >= 0 ; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                leftMax[stack.pop()] = i;
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightMax[i] - leftMax[i] - 1) * heights[i];
            max = Math.max(max , area);
        }
        return max;
    }
}
