class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) {
            var f = freq.getOrDefault(n, 0);
            freq.put(n, ++f);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            queue.offer(entry);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
