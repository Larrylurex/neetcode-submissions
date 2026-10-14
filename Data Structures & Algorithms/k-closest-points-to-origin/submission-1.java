class Solution {

    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        for(int[] p: points) {
            var d = p[0]*p[0] + p[1]*p[1];
            queue.add(new int[]{p[0], p[1], d});
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(i < k && !queue.isEmpty()) {
            int[] p = queue.poll();
            res[i] = new int[]{p[0], p[1]};  
            i++;          
        }
        return res;

    }
}
