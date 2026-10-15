class Solution {
public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), res, 0, target);
        return res;
    }

    void subset(int[] nums, int i, List<Integer> subset, List<List<Integer>> res, int sum, int target) {
        if (sum == target) { res.add(new ArrayList<>(subset)); return; }   // snapshot only here
        if (i == nums.length || sum > target) return;

        subset.add(nums[i]);
        subset(nums, i, subset, res, sum + nums[i], target);
        subset.remove(subset.size() - 1);

        subset(nums, i + 1, subset, res, sum, target );
    }
}
