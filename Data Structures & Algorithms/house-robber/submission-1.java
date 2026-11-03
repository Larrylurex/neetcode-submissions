class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return Math.max(rob(0, nums, cache), rob(1, nums, cache));
    }

    private int rob(int i, int[] nums, int[] cache) {
        if(i >= nums.length) return 0;
        if(cache[i] != -1) return cache[i];

        int sum = nums[i] + Math.max(rob(i + 2, nums, cache), rob(i + 3, nums, cache));
        cache[i] = sum;
        return sum;
    }
}
