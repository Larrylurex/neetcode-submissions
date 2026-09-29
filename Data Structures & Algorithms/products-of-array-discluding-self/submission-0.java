class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1;
        for(int i = 0; i < nums.length; i++) {
            res[i] = p;
            p = p * nums[i];
            for(int j = 0; j < i; j++) {
                res[j] = res[j] * nums[i];
            }
        }
        return res;
    }
}  
