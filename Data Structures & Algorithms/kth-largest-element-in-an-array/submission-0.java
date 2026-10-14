class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        queue.addAll( Arrays.stream(nums).boxed().toList());

        while(k > 1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}
