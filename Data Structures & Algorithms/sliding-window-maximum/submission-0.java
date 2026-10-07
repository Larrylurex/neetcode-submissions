class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int[] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int l = 0;
        int r = 0;
        while(r < nums.length) {
            while(queue.size() < k) {
                queue.add(nums[r++]);
            }
            res[l] = queue.peek();
            queue.remove(nums[l]);
            l++;
        }
        return res;
    }
}
