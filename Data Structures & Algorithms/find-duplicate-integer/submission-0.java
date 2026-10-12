class Solution {
    public int findDuplicate(int[] nums) {

        int fast = 0;
        int slow = 0;
        for(int i = 0; i < nums.length ; i++) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow) {
                break;
            }
        }

        int slow2 = 0;
        for(int i = 0; i < nums.length ; i++) {
            slow2 = nums[slow2];
            slow = nums[slow];
            if(slow2 == slow) {
                break;
            }
        }

        return slow2;
    }
}
