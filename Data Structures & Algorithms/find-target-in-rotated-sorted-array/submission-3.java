class Solution {
    //2, 3, 4, 5, 0, 1
    public int search(int[] nums, int target) {
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
        int cutIdx = left;

        if(target == nums[cutIdx]) {
            return cutIdx;
        }
        if(target > nums[nums.length -1 ]) {
            left = 0;
            right = cutIdx - 1;
                    
        } else {
            left = cutIdx + 1;
            right = nums.length - 1;
        }

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;

    }
}
