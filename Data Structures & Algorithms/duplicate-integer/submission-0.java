class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(unique.contains(nums[i])) {
                return true;
            } else {
                unique.add(nums[i]);
            }
        }
        return false;
    }
}
