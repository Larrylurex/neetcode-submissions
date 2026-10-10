class Solution {

    // 3,4,5,6,1,2
    // l = 0, r = 5, m =2
    // l = 3, r = 5, m = 4
    // l = 3, r = 3, m = 
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1; 
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
