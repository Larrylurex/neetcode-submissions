class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length <= 1) return false;

        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}