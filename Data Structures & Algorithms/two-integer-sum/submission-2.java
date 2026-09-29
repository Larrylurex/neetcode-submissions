class Solution {
    public int[] twoSum(int[] nums, int target) {
       var diffMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            Integer idx = diffMap.get(nums[i]);
            if(idx != null) {
                return new int[]{idx, i};
            } else {
                diffMap.put(target - nums[i], i);
            }
        }
        return new int[0]; 
    }
}
