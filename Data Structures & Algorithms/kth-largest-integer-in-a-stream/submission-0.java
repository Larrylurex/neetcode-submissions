class KthLargest {

    private Queue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        queue.addAll( Arrays.stream(nums).boxed().toList());
        while(queue.size() > k) {
            queue.poll();
        }
        this.k = k;
    }

    public int add(int val) {
        queue.add(val);
        while(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
