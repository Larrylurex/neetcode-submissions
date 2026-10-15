class Solution {
        record Pair(int count, int time){}
public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] count = new int[26];
        for (char task: tasks) {
            count[task - 'A']++;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        for(int c : count) {
            if(c != 0) maxHeap.add(c);
        }

        Queue<Pair> queue = new LinkedList<>();

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int task = maxHeap.poll() - 1;
                if(task !=0) {
                    queue.add(new Pair(task, time + n));
                }
            }
            if(!queue.isEmpty()) {
                if(queue.peek().time == time) {
                    Pair polled = queue.poll();
                    maxHeap.add(polled.count);
                }
            }
        }
        return time;
    }
}
