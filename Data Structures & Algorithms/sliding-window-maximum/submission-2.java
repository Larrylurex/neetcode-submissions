class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int l = 0;
        int r = 0;
        while(r < nums.length) {
            while(r - l < k) {
                queue.add(new int[]{nums[r], r});
                r++;
            }
            while(queue.peek()[1] < l) {
                queue.poll();
            }
            res[l] = queue.peek()[0];
            l++;
        }
        return res;
    }
}
