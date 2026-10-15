class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        subset(candidates, 0, new ArrayList<>(), res, 0, target);
        return res;
    }

    void subset(int[] nums, int i, List<Integer> subset, List<List<Integer>> res, int sum, int target) {
        if (sum == target) { res.add(new ArrayList<>(subset)); return; } 
        if (i == nums.length || sum > target) return;

        subset.add(nums[i]);
        subset(nums, i + 1, subset, res, sum + nums[i], target);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }   
        subset(nums, i + 1, subset, res, sum, target );
    }
}
