class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if(i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        cur.add(nums[i]);
        backtrack(nums, i + 1, cur, res);
        cur.remove(cur.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, i + 1, cur, res);
    }
}
