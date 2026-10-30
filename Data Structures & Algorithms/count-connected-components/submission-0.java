class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] added = new boolean[n];

        Queue<int[]> queue = new ArrayDeque<>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (added[i])
                continue;

            counter++;
            queue.add(new int[] {i, -1});
            added[i] = true;

            while (!queue.isEmpty()) {
                int[] node = queue.poll();

                for (var dep : graph.get(node[0])) {
                    if (!added[dep]) {
                        added[dep] = true;
                        queue.offer(new int[] {dep, node[0]});
                    }
                }
            }
        }

        return counter;
    }
}
