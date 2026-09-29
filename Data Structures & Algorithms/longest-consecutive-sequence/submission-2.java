class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int startSeq = 0;
        int maxL = 1;
        for(int i = 0; i < nums.length; i++) {
            if(i == nums.length -1) {
                maxL = Math.max(maxL, i - startSeq + 1);
                break;
            }
            if(nums[i + 1] - nums[i]  == 0) {
                startSeq++;
            } else if (nums[i + 1] - nums[i]   != 1) {
                maxL = Math.max(maxL, i - startSeq + 1);
                startSeq = i + 1;
            }
        }
        return maxL;
    }
}
