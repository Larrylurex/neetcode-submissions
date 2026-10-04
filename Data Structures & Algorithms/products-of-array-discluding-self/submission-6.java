class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[ i - 1] * nums[i - 1];
        }
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        suffix[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            res[i + 1] = prefix[ i + 1] * suffix[i + 1];
            suffix[i] = suffix[ i + 1] * nums[i + 1];
        }
        res[0] = prefix[0] * suffix[0];
        return res;
    }
}  
