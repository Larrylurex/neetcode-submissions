class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int left = 0;
        int right = nums.length - 1;

        int[] values = new int[2]; 
        while(left != right) {
            int sum = sorted[left] + sorted[right];
            if(sum == target) {
                values[0] = sorted[left];
                values[1] = sorted[right];
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        int ci = 0;
        int[] res = new int[2];
        for(int i = 0; i < nums.length && ci < 2; i++) {
            if(nums[i] == values[0] || nums[i] == values[1]) {
                res[ci] = i;
                ci++;
            }
        }
        return res;
    }
}
