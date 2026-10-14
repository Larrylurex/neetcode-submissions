class Solution {
    record Point(int[] p, double d){}
    public int[][] kClosest(int[][] points, int k) {

        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> a.d));
        for(int[] p: points) {
            var d = Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
            queue.add(new Point(p, d));
        }

        int[][] res = new int[k][];
        int i = 0;
        while(i < k && !queue.isEmpty()) {
            res[i] = queue.poll().p;
            i++;
        }
        return res;

    }
}
