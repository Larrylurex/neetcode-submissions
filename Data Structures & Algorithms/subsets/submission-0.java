class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void subset(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if(i == nums.length) {
            res.add(subset);
        } else {
            subset(nums, i + 1, subset, res);
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[i]);
            subset(nums, i + 1, newSubset, res);
        }
    }
}
