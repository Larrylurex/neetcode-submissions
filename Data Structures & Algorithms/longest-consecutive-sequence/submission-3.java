class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        Arrays.sort(nums);
        int max = 1;
        int curMax = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                curMax++;
                continue;
            }
            if(nums[i] - nums[i-1] == 0) {
                continue;
            }
            max = Math.max( max, curMax);
            curMax = 1;
        }
        return Math.max( max, curMax);
    }
}
