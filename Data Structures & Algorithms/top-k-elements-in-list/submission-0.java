class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        List<int[]> numsCount = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = 1;
            while(i + 1 < nums.length && nums[i + 1] == first) {
                second++;
                i++;
            }
            numsCount.add(new int[]{first, second});
        }
        Collections.sort(numsCount, (a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < result.length; i++) {
            result[i] = numsCount.get(i)[0];
        }

        return result;
    }
}
