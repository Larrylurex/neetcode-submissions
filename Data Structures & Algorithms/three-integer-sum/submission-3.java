class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length  - 1;
            int target = -nums[i];
            while(j < k) {
                int sumTwo = nums[j] + nums[k];
                if(sumTwo == target) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                } else if(sumTwo < target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
