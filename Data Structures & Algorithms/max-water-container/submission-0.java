class Solution {
    public int maxArea(int[] heights) {
        

        int i = 0;
        int j = heights.length - 1;
        int maxArea = 0;
        while (i < j) {
            int w = j - i;
            int h = Math.min(heights[i], heights[j]);
            maxArea = Math.max(maxArea, h*w);

            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
