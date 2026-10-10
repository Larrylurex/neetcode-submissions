class Solution {


    // -1,0,2,4,6,8 t = 4
    // f = 0, t = 5, m = 2
    // f = 3, t = 5, m = 4
    // f = 3, t = 3, m
    public int search(int[] nums, int target) {
        int from = 0;
        int to = nums.length - 1;
        while(from <= to) {
            int mid = from + (to - from) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return -1;
    }
}
