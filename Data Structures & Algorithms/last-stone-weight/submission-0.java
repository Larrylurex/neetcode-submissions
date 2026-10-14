class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());

        queue.addAll(Arrays.stream(stones).boxed().toList());


        while(queue.size() > 1) {
            var s1 = queue.poll();
            var s2 = queue.poll();
            var diff = Math.abs(s1 - s2);
            if(diff == 0) continue;
            queue.add(diff);            
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
