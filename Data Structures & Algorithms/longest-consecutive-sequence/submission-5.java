class Solution {
    public int longestConsecutive(int[] nums) {
         if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int max = 1;
        for(int n: set) {
            if(set.contains(n - 1)) continue;

            int length = 1;
            while(set.contains(n + length)) {
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
