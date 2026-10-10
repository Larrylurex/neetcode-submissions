class Solution {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    int search(int[] nums, int target, int from, int to) {
        if(to < from) return -1;

        int mid = from + (to - from) / 2;
        if(nums[mid] > target) {
            return search(nums, target, from, mid - 1);
        } else if(nums[mid] < target) {
            return search(nums, target, mid + 1, to);
        } else {
            return mid;
        }
    }

}
