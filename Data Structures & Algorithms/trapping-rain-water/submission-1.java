class Solution {
    public int trap(int[] height) {
         int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft < maxRight) {
                res += Math.max(0, maxLeft - height[left]);
                left++;
            } else {
                res += Math.max(0, maxRight - height[right]);
                right--;
            }
        }
        return res;
    }
}
