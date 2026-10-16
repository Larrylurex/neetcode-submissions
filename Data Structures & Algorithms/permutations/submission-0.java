class Solution {
   public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(nums, new ArrayList<>(),  new boolean[nums.length], res);
        return res;
    }

    void traverse(int[] nums, List<Integer> cur, boolean[] used, List<List<Integer>> res) {
        if(cur.size() == nums.length) {
            System.out.println(cur);
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                traverse(nums, cur, used, res);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}
